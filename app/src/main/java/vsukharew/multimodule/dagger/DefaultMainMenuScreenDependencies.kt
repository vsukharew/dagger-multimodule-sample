package vsukharew.multimodule.dagger

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.order.api.OrderFeatureApi
import vsukharew.multimodule.main_menu.di.MainMenuScreenDependencies

class DefaultMainMenuScreenDependencies(
    override val router: Router,
    override val orderFeatureApi: OrderFeatureApi,
    override val calendarFeatureApi: CalendarFeatureApi,
) : MainMenuScreenDependencies