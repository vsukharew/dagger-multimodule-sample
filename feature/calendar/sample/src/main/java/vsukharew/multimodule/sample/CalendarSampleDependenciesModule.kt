package vsukharew.multimodule.sample

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.core.di.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import javax.inject.Singleton

@Module
internal interface CalendarSampleDependenciesModule {
    @Binds
    @Singleton
    @IntoMap
    @DependenciesKey(CalendarDependencies::class)
    fun bindCalendarDependencies(
        impl: SampleCalendarDependencies
    ): Dependencies
}