package vsukharew.multimodule.dagger.dependencies.calendar

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import javax.inject.Inject

class DefaultCalendarDependencies @Inject constructor(
    override val router: Router,
    override val profileRepo: ProfileRepo,
) : CalendarDependencies