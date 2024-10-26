package vsukharew.multimodule.dagger.calendar.impl.di.module

import dagger.Binds
import dagger.Module
import vsukharew.multimodule.dagger.calendar.api.CalendarRouter
import vsukharew.multimodule.dagger.calendar.impl.presentation.CalendarNavigation
import javax.inject.Singleton

@Module
internal interface CalendarApiModule {
    @Binds
    @Singleton
    fun bindCalendarRouter(impl: CalendarNavigation): CalendarRouter
}