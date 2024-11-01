package vsukharew.multimodule.dagger.core.di.dependencies

import vsukharew.multimodule.dagger.core.di.provider.DependenciesProvider

interface HasDependencies {
    val dependenciesProvider: DependenciesProvider
}