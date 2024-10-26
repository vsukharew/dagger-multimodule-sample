package vsukharew.multimodule.dagger.core.di.component

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Component
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.module.CoreModule
import vsukharew.multimodule.dagger.core.di.module.NavigationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NavigationModule::class,
    CoreModule::class,
])
interface CoreComponent : DaggerComponent {
    fun router(): Router
    fun profileRepo(): ProfileRepo
    fun navigatorHolder(): NavigatorHolder
}