package vsukharew.multimodule.dagger.calendar.impl.di.component

import dagger.Component
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.calendar.impl.presentation.CalendarFragment
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.PerScreen
import vsukharew.multimodule.dagger.core.di.utils.clearScreenDependencies
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.core.di.utils.releaseComponent
import vsukharew.multimodule.dagger.core.di.utils.resolveDependency

@Component(
    dependencies = [
        CalendarDependencies::class,
        CalendarDataComponent::class,
    ]
)
@PerScreen
internal interface CalendarScreenComponent : DaggerComponent {
    fun inject(fragment: CalendarFragment)

    companion object {
        fun build(
            fragment: CalendarFragment
        ): CalendarScreenComponent {
            return with(fragment) {
                DaggerCalendarScreenComponent.builder()
                    .calendarDependencies(resolveDependency())
                    .calendarDataComponent(getOrCreateComponent { CalendarDataComponent.build() })
                    .build()
            }
        }

        fun release(fragment: CalendarFragment) {
            with(fragment) {
                releaseComponent<CalendarScreenComponent>()
                activity?.run {
                    if (!isChangingConfigurations) {
                        CalendarDataComponent.release(fragment)
                        releaseComponent<CalendarApiComponent>()
                        clearScreenDependencies<CalendarDependencies>()
                    }
                }
            }
        }
    }
}