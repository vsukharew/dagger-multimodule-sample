package vsukharew.multimodule.dagger.core.di.utils

import androidx.fragment.app.Fragment
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider

inline fun <reified T : Dependencies> Fragment.resolveDependency(): T =
    (requireContext().applicationContext as DependenciesProvider).getDependencies(T::class)

inline fun <reified T : Dependencies> Fragment.clearScreenDependencies() =
    (requireContext().applicationContext as DependenciesProvider).clearDependencies(T::class)