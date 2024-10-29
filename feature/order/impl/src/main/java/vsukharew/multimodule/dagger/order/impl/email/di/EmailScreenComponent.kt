package vsukharew.multimodule.dagger.order.impl.email.di

import androidx.fragment.app.Fragment
import dagger.Component
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.dependencies.InnerNavigationScreenDependencies
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.core.di.utils.releaseComponent
import vsukharew.multimodule.dagger.core.di.utils.resolveDependency
import vsukharew.multimodule.dagger.order.impl.email.presentation.EmailFragment
import vsukharew.multimodule.dagger.order.impl.flow.di.OrderFlowScreenComponent
import vsukharew.multimodule.dagger.order.impl.flow.di.OrderFlowScreenInnerDependencies

@Component(
    dependencies = [InnerNavigationScreenDependencies::class]
)
internal interface EmailScreenComponent : DaggerComponent {
    fun inject(fragment: EmailFragment)
    fun dependencies(): InnerNavigationScreenDependencies

    companion object {
        fun build(fragment: Fragment): EmailScreenComponent {
            return with(fragment) {
                val orderFlowComponent =
                    getOrCreateComponent { OrderFlowScreenComponent.build(resolveDependency()) }

                DaggerEmailScreenComponent.builder()
                    .innerNavigationScreenDependencies(
                        OrderFlowScreenInnerDependencies(orderFlowComponent)
                    )
                    .build()
            }
        }

        fun release(fragment: Fragment) {
            with(fragment) {
                if (activity?.isChangingConfigurations == false) {
                    releaseComponent<EmailScreenComponent>()
                }
            }
        }
    }
}