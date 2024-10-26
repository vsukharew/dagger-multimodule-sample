package vsukharew.multimodule.main_menu.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.order.api.OrderFeatureApi

class MainMenuViewModel @AssistedInject constructor(
    private val router: Router,
    private val calendarFeatureApi: CalendarFeatureApi,
    private val orderFeatureApi: OrderFeatureApi,
    @Assisted private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    fun order() {
        orderFeatureApi.orderRouter().startOrderFlow()
    }

    fun registration() {
//        registrationRouter.navigateToRegistration()
    }

    fun calendar() {
        calendarFeatureApi.calendarRouter().navigateToCalendar()
    }

    @AssistedFactory
    interface Factory {
        fun create(handle: SavedStateHandle): MainMenuViewModel
    }
}