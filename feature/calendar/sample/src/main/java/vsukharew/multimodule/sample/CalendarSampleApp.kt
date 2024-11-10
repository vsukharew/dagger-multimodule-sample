package vsukharew.multimodule.sample

import android.app.Application
import vsukharew.multimodule.dagger.core.di.dependencies.HasDependencies
import vsukharew.multimodule.dagger.core.di.provider.DependenciesProvider

class CalendarSampleApp : Application(), HasDependencies {
    override val dependenciesProvider: DependenciesProvider = CalendarDependenciesProvider()
}