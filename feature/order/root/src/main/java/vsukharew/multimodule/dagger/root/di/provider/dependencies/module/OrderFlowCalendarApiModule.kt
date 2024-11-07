package vsukharew.multimodule.dagger.root.di.provider.dependencies.module

import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.calendar.impl.di.component.CalendarApiComponent
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.PerFeature

@Module
internal object OrderFlowCalendarApiModule {
    @Provides
    @PerFeature
    fun provideCalendarApi(
        @Flow router: Router
    ): CalendarFeatureApi = CalendarApiComponent.build(router)
}