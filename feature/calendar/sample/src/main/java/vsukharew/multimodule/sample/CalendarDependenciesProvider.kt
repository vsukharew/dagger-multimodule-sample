package vsukharew.multimodule.sample

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.component.DaggerCoreComponent
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.provider.AbstractDependenciesProvider
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import kotlin.reflect.KClass

class CalendarDependenciesProvider : AbstractDependenciesProvider() {
    private val coreComponent = getOrCreateComponent { DaggerCoreComponent.create() }

    override fun <T : Dependencies> createDependencies(dependenciesClass: KClass<T>): Dependencies? {
        return SampleCalendarDependencies(
            coreComponent.router(),
            coreComponent.profileRepo()
        ).takeIf { dependenciesClass == CalendarDependencies::class }
    }

    private data class SampleCalendarDependencies(
        override val router: Router,
        override val profileRepo: ProfileRepo
    ) : CalendarDependencies
}