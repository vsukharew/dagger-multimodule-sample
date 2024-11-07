package vsukharew.multimodule.dagger.calendar.impl.di

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies

interface CalendarDependencies : Dependencies {
    val router: Router
    val profileRepo: ProfileRepo
}