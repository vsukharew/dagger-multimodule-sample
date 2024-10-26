package vsukharew.multimodule.dagger.core.di.utils

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider

inline fun <reified T : DaggerComponent> DependenciesProvider.getOrCreateComponent(creationBlock: () -> T): T {
    return componentsStorage[T::class] as? T ?: creationBlock.invoke().also {
        componentsStorage[T::class] = it
    }
}

inline fun <reified T : DaggerComponent> Application.getOrCreateComponent(creationBlock: () -> T): T =
    (this as DependenciesProvider).getOrCreateComponent(creationBlock)

inline fun <reified T : DaggerComponent> Activity.getOrCreateComponent(creationBlock: () -> T): T =
    application.getOrCreateComponent(creationBlock)

inline fun <reified T : DaggerComponent> Fragment.getOrCreateComponent(creationBlock: () -> T): T =
    requireActivity().getOrCreateComponent(creationBlock)

inline fun <reified T : DaggerComponent> Fragment.releaseComponent() =
    activity?.releaseComponent<T>()

inline fun <reified T : DaggerComponent> Activity.releaseComponent() =
    (application as DependenciesProvider).componentsStorage.remove(T::class)
