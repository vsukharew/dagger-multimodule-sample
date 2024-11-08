package vsukharew.multimodule.dagger.core.di.utils

import androidx.fragment.app.Fragment
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.dependencies.HasDependencies
import vsukharew.multimodule.dagger.core.ui.extension.allParents

inline fun <reified T : Dependencies> Fragment.resolveDependency(): T {
    return allParents
        .onEach { println("resolve dependency - child = $this, parent = $it") }
        .filterIsInstance<HasDependencies>()
        .map { it.dependenciesProvider.getDependencies(T::class) as? T }
        .firstOrNull() ?: throw IllegalArgumentException()
}