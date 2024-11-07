package vsukharew.multimodule.dagger.module.calendar

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.dependencies.calendar.DefaultCalendarDependencies
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.core.di.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import javax.inject.Singleton

@Module
internal interface CalendarDependenciesModule {

    @Binds
    @IntoMap
    @DependenciesKey(CalendarDependencies::class)
    @Singleton
    fun bindCalendarDependencies(impl: DefaultCalendarDependencies): Dependencies
}