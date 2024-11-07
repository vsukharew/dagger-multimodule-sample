package vsukharew.multimodule.dagger.root.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.order.impl.email.presentation.EmailScreen

internal class OrderFlowViewModel @AssistedInject constructor(
    private val globalRouter: Router,
    @Flow private val flowRouter: Router,
    @Assisted private val handle: SavedStateHandle,
) : ViewModel() {

    fun startFlow() {
        flowRouter.navigateTo(EmailScreen)
    }

    fun back() {
        globalRouter.exit()
    }

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): OrderFlowViewModel
    }
}