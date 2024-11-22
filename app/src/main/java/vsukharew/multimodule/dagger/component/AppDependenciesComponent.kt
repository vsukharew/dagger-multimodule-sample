package vsukharew.multimodule.dagger.component

import com.github.terrakok.cicerone.Router
import dagger.Component
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.component.DependenciesComponent
import vsukharew.multimodule.dagger.module.CommonApiModule
import vsukharew.multimodule.dagger.module.CommonDependenciesModule
import javax.inject.Singleton

@Component(
    modules = [
        CommonDependenciesModule::class,
        CommonApiModule::class
    ],
    dependencies = [Router::class, ProfileRepo::class]
)
@Singleton
interface AppDependenciesComponent : DependenciesComponent