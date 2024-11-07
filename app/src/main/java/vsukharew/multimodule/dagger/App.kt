package vsukharew.multimodule.dagger

import android.app.Application
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider
import vsukharew.multimodule.dagger.core.di.dependencies.HasDependencies

class App : Application(), HasDependencies {
    override val dependenciesProvider: DependenciesProvider = AppWideDependenciesProvider(this)
}