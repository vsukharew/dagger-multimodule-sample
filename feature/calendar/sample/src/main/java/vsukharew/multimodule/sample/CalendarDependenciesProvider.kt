package vsukharew.multimodule.sample

import vsukharew.multimodule.dagger.core.di.component.DaggerCoreComponent
import vsukharew.multimodule.dagger.core.di.component.DependenciesComponent
import vsukharew.multimodule.dagger.core.di.provider.AbstractDependenciesProvider
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent

internal class CalendarDependenciesProvider : AbstractDependenciesProvider() {
    override val dependenciesComponent: DependenciesComponent by lazy {
        getOrCreateComponent { DaggerCoreComponent.create() }.run {
            DaggerCalendarSampleDependenciesComponent.builder()
                .router(router())
                .profileRepo(profileRepo())
                .build()
        }
    }
}