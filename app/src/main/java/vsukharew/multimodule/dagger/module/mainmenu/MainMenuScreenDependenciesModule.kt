package vsukharew.multimodule.dagger.module.mainmenu

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.dependencies.mainmenu.DefaultMainMenuScreenDependencies
import vsukharew.multimodule.dagger.module.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.main_menu.di.MainMenuScreenDependencies

@Module
interface MainMenuScreenDependenciesModule {

    @Binds
    @IntoMap
    @DependenciesKey(MainMenuScreenDependencies::class)
    fun bindMainMenuScreenDependencies(impl: DefaultMainMenuScreenDependencies): Dependencies
}