package vsukharew.multimodule.dagger

import dagger.Component
import vsukharew.multimodule.dagger.core.di.component.CoreComponent

import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.core.di.component.DaggerCoreComponent
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.core.di.utils.releaseComponent

@Component(
    dependencies = [CoreComponent::class]
)
@PerFeature
abstract class MainComponent : DaggerComponent {
    abstract fun inject(mainActivity: MainActivity)

    companion object {
        fun build(activity: MainActivity): MainComponent {
            val coreComponent = activity.getOrCreateComponent { DaggerCoreComponent.create() }
            return DaggerMainComponent.builder()
                .coreComponent(coreComponent)
                .build()
        }

        fun release(activity: MainActivity) {
            with(activity) {
                if (!isChangingConfigurations) {
                    releaseComponent<MainComponent>()
                }
            }
        }
    }
}