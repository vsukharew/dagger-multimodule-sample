package vsukharew.multimodule.dagger.order.impl.email.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import org.intellij.lang.annotations.Flow
import vsukharew.multimodule.dagger.order.impl.address.presentation.AddressScreen

internal class EmailViewModel @AssistedInject constructor(
    private val globalRouter: Router,
    @Assisted private val flowRouter: Router,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun next() {
        flowRouter.navigateTo(AddressScreen)
    }

    fun back() {
        globalRouter.exit()
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Flow flowRouter: Router,
            savedStateHandle: SavedStateHandle
        ): EmailViewModel
    }
}