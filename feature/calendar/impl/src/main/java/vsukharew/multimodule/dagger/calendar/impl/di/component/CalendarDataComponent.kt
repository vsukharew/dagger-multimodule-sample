package vsukharew.multimodule.dagger.calendar.impl.di.component

import dagger.Component
import vsukharew.multimodule.dagger.calendar.impl.presentation.CalendarFragment
import vsukharew.multimodule.dagger.calendar.impl.di.module.CalendarImplModule
import vsukharew.multimodule.dagger.calendar.impl.domain.CalendarInteractor
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.PerScreenRetained
import vsukharew.multimodule.dagger.core.di.utils.releaseComponent

@Component(
    modules = [CalendarImplModule::class]
)
@PerScreenRetained
internal interface CalendarDataComponent : DaggerComponent {
    fun calendarInteractor(): CalendarInteractor

    companion object {
        fun build(): CalendarDataComponent {
            return DaggerCalendarDataComponent.builder()
                .build()
        }

        fun release(fragment: CalendarFragment) {
            fragment.releaseComponent<CalendarDataComponent>()
        }
    }
}