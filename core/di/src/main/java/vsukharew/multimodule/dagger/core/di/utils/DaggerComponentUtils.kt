package vsukharew.multimodule.dagger.core.di.utils

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider
import vsukharew.multimodule.dagger.core.di.dependencies.HasDependencies
import vsukharew.multimodule.dagger.core.ui.extension.allParents

inline fun <reified T : DaggerComponent> DependenciesProvider.getOrCreateComponent(
    noinline creationBlock: () -> T
): T = getOrCreateComponent(T::class, creationBlock) as T

inline fun <reified T : DaggerComponent> Application.getOrCreateComponent(noinline creationBlock: () -> T): T =
    (this as HasDependencies).dependenciesProvider.getOrCreateComponent(creationBlock)

inline fun <reified T : DaggerComponent> Activity.getOrCreateComponent(noinline creationBlock: () -> T): T =
    application.getOrCreateComponent(creationBlock)

inline fun <reified T : DaggerComponent> Fragment.getOrCreateComponent(noinline creationBlock: () -> T): T =
    allParents
        .onEach { println("getOrCreateComponent - child - $this, parent = $it") }
        .filterIsInstance<HasDependencies>()
        .first()
        .dependenciesProvider.getOrCreateComponent(T::class, creationBlock) as T


inline fun <reified T : DaggerComponent> Fragment.releaseComponent() =
    allParents
        .filterIsInstance<HasDependencies>()
        .map(HasDependencies::dependenciesProvider)
        .firstOrNull { it.containsComponent(T::class) }
        ?.releaseComponent(T::class)

inline fun <reified T : DaggerComponent> Activity.releaseComponent() =
    (application as HasDependencies).dependenciesProvider.releaseComponent(T::class)
