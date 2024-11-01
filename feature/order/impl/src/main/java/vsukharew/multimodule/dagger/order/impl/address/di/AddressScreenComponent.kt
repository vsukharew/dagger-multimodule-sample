package vsukharew.multimodule.dagger.order.impl.address.di

import androidx.fragment.app.Fragment
import dagger.Component
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.utils.clearScreenDependencies
import vsukharew.multimodule.dagger.core.di.utils.releaseComponent
import vsukharew.multimodule.dagger.core.di.utils.resolveDependency
import vsukharew.multimodule.dagger.order.impl.address.presentation.AddressFragment

@Component(
    dependencies = [
        AddressScreenDependencies::class
    ]
)
@PerFeature
internal interface AddressScreenComponent : DaggerComponent {
    fun inject(fragment: AddressFragment)
    fun addressScreenDependencies(): AddressScreenDependencies

    companion object {

        fun build(fragment: Fragment): AddressScreenComponent {
            return with(fragment) {
                DaggerAddressScreenComponent.builder()
                    .addressScreenDependencies(resolveDependency())
                    .build()
            }
        }

        fun release(fragment: Fragment) {
            with(fragment) {
                if (activity?.isChangingConfigurations == false) {
                    releaseComponent<AddressScreenComponent>()
                    clearScreenDependencies<AddressScreenDependencies>()
                }
            }
        }
    }
}