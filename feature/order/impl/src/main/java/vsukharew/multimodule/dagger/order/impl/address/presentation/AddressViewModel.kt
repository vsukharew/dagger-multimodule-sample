package vsukharew.multimodule.dagger.order.impl.address.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi

internal class AddressViewModel @AssistedInject constructor(
    @Assisted private val calendarFeatureApi: CalendarFeatureApi,
    @Assisted("Global") private val globalRouter: Router,
    @Assisted("Flow") private val flowRouter: Router,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun back() {
        flowRouter.exit()
    }

    fun createOrder() {
        globalRouter.exit()
    }

    fun openCalendar() {
        calendarFeatureApi.calendarRouter().navigateToCalendar()
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted calendarFeatureApi: CalendarFeatureApi,
            @Assisted("Global") globalRouter: Router,
            @Assisted("Flow") flowRouter: Router,
            savedStateHandle: SavedStateHandle
        ): AddressViewModel
    }
}