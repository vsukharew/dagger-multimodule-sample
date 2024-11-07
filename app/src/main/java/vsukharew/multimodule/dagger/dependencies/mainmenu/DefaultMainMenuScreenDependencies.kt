package vsukharew.multimodule.dagger.dependencies.mainmenu

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.order.api.OrderFeatureApi
import vsukharew.multimodule.main_menu.di.MainMenuScreenDependencies
import javax.inject.Inject

class DefaultMainMenuScreenDependencies @Inject constructor(
    override val router: Router,
    override val orderFeatureApi: OrderFeatureApi,
    override val calendarFeatureApi: CalendarFeatureApi,
) : MainMenuScreenDependencies