package vsukharew.multimodule.dagger.root.di.component

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import dagger.Component
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.core.di.utils.clearScreenDependencies
import vsukharew.multimodule.dagger.core.di.utils.releaseComponent
import vsukharew.multimodule.dagger.root.di.dependencies.OrderFlowDependencies
import vsukharew.multimodule.dagger.root.di.module.InnerNavigationModule
import vsukharew.multimodule.dagger.root.presentation.OrderFlowFragment

@Component(
    modules = [
        InnerNavigationModule::class,
    ],
    dependencies = [
        OrderFlowDependencies::class
    ]
)
@PerFeature
internal interface OrderFlowScreenComponent : DaggerComponent {
    fun inject(fragment: OrderFlowFragment)
    fun router(): Router
    @Flow
    fun flowRouter(): Router
    fun profileRepo(): ProfileRepo

    companion object {

        fun build(dependencies: OrderFlowDependencies): OrderFlowScreenComponent {
            return DaggerOrderFlowScreenComponent.builder()
                .orderFlowDependencies(dependencies)
                .build()
        }

        fun release(fragment: Fragment) {
            with(fragment) {
                if (activity?.isChangingConfigurations == false) {
                    releaseComponent<OrderFlowScreenComponent>()
                    releaseComponent<OrderApiComponent>()
                    clearScreenDependencies<OrderFlowDependencies>()
                }
            }
        }
    }
}