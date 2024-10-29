package vsukharew.multimodule.dagger.order.impl.address.di

import androidx.fragment.app.Fragment
import dagger.Component
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.core.di.utils.releaseComponent
import vsukharew.multimodule.dagger.core.di.utils.resolveDependency
import vsukharew.multimodule.dagger.order.impl.address.presentation.AddressFragment
import vsukharew.multimodule.dagger.order.impl.flow.di.OrderFlowScreenComponent

@Component(
    dependencies = [
        AddressScreenExternalDependencies::class,
        AddressScreenInternalDependencies::class,
    ]
)
@PerFeature
internal interface AddressScreenComponent : DaggerComponent {
    fun inject(fragment: AddressFragment)
    fun addressScreenExternalDependencies(): AddressScreenExternalDependencies
    fun addressScreenInternalDependencies(): AddressScreenInternalDependencies

    companion object {

        fun build(fragment: Fragment): AddressScreenComponent {
            return with(fragment) {
                DaggerAddressScreenComponent.builder()
                    .addressScreenExternalDependencies(resolveDependency())
                    .addressScreenInternalDependencies(
                        getOrCreateComponent {
                            OrderFlowScreenComponent.build(resolveDependency())
                        }
                    )
                    .build()
            }
        }

        fun release(fragment: Fragment) {
            with(fragment) {
                if (activity?.isChangingConfigurations == false) {
                    releaseComponent<AddressScreenComponent>()
                    
                }
            }
        }
    }
}