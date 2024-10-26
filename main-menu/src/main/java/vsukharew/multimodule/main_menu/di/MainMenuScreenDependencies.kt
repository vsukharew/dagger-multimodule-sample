package vsukharew.multimodule.main_menu.di

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.order.api.OrderFeatureApi

interface MainMenuScreenDependencies : Dependencies {
    val router: Router
    val orderFeatureApi: OrderFeatureApi
    val calendarFeatureApi: CalendarFeatureApi
}