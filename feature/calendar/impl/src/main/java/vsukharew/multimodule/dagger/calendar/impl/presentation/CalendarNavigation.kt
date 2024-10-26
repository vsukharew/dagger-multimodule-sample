package vsukharew.multimodule.dagger.calendar.impl.presentation

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.api.CalendarRouter
import javax.inject.Inject

class CalendarNavigation @Inject constructor(
    private val router: Router
) : CalendarRouter {
    override fun navigateToCalendar() {
        router.navigateTo(CalendarScreen())
    }
}