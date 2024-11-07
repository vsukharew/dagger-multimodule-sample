package vsukharew.multimodule.dagger.core.di.component

import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import javax.inject.Provider

interface DependenciesComponent {
    val dependencies: Map<Class<out Dependencies>, @JvmSuppressWildcards Provider<Dependencies>>
}