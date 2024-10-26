package vsukharew.multimodule.dagger.order.impl.flow.di

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import dagger.Component
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.core.di.utils.clearScreenDependencies
import vsukharew.multimodule.dagger.core.di.utils.releaseComponent
import vsukharew.multimodule.dagger.order.impl.di.OrderApiComponent
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenInternalDependencies
import vsukharew.multimodule.dagger.order.impl.flow.presentation.OrderFlowFragment

@Component(
    modules = [
        InnerNavigationModule::class,
    ],
    dependencies = [
        OrderFlowScreenExternalDependencies::class
    ]
)
@PerFeature
internal interface OrderFlowScreenComponent : AddressScreenInternalDependencies, DaggerComponent {
    fun inject(fragment: OrderFlowFragment)
    fun router(): Router

    companion object {

        fun build(dependencies: OrderFlowScreenExternalDependencies): OrderFlowScreenComponent {
            return DaggerOrderFlowScreenComponent.builder()
                .orderFlowScreenExternalDependencies(dependencies)
                .build()
        }

        fun release(fragment: Fragment) {
            with(fragment) {
                if (activity?.isChangingConfigurations == false) {
                    releaseComponent<OrderFlowScreenComponent>()
                    releaseComponent<OrderApiComponent>()
                    clearScreenDependencies<OrderFlowScreenExternalDependencies>()
                }
            }
        }
    }
}