package vsukharew.multimodule.dagger.core.di

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class ViewModelFactory(
    savedStateRegistryOwner: SavedStateRegistryOwner,
    private val viewModelCreationBlock: (SavedStateHandle) -> ViewModel
): AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return viewModelCreationBlock.invoke(handle) as T
    }
}