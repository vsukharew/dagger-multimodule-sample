package vsukharew.multimodule.sample

import com.github.terrakok.cicerone.Router
import dagger.Component
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.component.DependenciesComponent
import javax.inject.Singleton

@Component(
    modules = [CalendarSampleDependenciesModule::class],
    dependencies = [
        Router::class,
        ProfileRepo::class
    ]
)
@Singleton
internal interface CalendarSampleDependenciesComponent : DependenciesComponent