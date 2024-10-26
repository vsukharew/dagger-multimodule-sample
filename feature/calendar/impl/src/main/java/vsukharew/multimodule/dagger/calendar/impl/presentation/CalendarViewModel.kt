package vsukharew.multimodule.dagger.calendar.impl.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import vsukharew.multimodule.dagger.calendar.impl.domain.CalendarInteractor
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo

class CalendarViewModel @AssistedInject constructor(
    private val router: Router,
    @Assisted private val savedStateHandle: SavedStateHandle,
    calendarInteractor: CalendarInteractor,
    profileRepo: ProfileRepo,
) : ViewModel() {

    init {
        println("events count = ${calendarInteractor.getEventsCount()}")
        println("profile id = ${profileRepo.getProfileId()}")
    }

    fun back() {
        router.exit()
    }

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): CalendarViewModel
    }
}