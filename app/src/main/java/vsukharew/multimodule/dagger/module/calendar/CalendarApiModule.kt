package vsukharew.multimodule.dagger.module.calendar

import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.calendar.impl.di.component.CalendarApiComponent
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import javax.inject.Singleton

@Module
object CalendarApiModule {

    @Provides
    @Singleton
    fun provideCalendarApi(
        router: Router
    ): CalendarFeatureApi = CalendarApiComponent.build(router)
}