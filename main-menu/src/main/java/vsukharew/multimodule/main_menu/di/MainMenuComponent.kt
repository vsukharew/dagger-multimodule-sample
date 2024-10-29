package vsukharew.multimodule.main_menu.di

import androidx.fragment.app.Fragment
import dagger.Component

import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.PerFeature

import vsukharew.multimodule.dagger.core.di.utils.releaseComponent
import vsukharew.multimodule.dagger.core.di.utils.resolveDependency
import vsukharew.multimodule.main_menu.presentation.MainMenuFragment

@Component(
    dependencies = [
        MainMenuScreenDependencies::class
    ]
)
@PerFeature
interface MainMenuComponent : DaggerComponent {
    fun inject(fragment: MainMenuFragment)

    companion object {
        fun build(fragment: Fragment): MainMenuComponent {
            return DaggerMainMenuComponent.builder()
                .mainMenuScreenDependencies(fragment.resolveDependency())
                .build()
        }

        fun release(fragment: Fragment) {
            with(fragment) {
                if (activity?.isChangingConfigurations == false) {
                    releaseComponent<MainMenuComponent>()
                }
            }
        }
    }
}