package vsukharew.multimodule.dagger.calendar.impl.di.module

import dagger.Binds
import dagger.Module
import vsukharew.multimodule.dagger.calendar.impl.domain.CalendarInteractor
import vsukharew.multimodule.dagger.calendar.impl.domain.CalendarInteractorImpl
import vsukharew.multimodule.dagger.core.di.PerScreenRetained

@Module
internal interface CalendarImplModule {
    @Binds
    @PerScreenRetained
    fun bindCalendarInteractor(impl: CalendarInteractorImpl): CalendarInteractor
}