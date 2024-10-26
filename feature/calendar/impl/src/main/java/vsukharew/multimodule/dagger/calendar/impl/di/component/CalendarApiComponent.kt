package vsukharew.multimodule.dagger.calendar.impl.di.component

import com.github.terrakok.cicerone.Router
import dagger.Component
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.calendar.impl.di.module.CalendarApiModule
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import javax.inject.Singleton

@Component(
    modules = [CalendarApiModule::class],
    dependencies = [Router::class]
)
@Singleton
interface CalendarApiComponent : CalendarFeatureApi, DaggerComponent {
    fun router(): Router

    companion object {
        fun build(router: Router): CalendarApiComponent {
            return DaggerCalendarApiComponent.builder()
                .router(router)
                .build()
        }
    }
}