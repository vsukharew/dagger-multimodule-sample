package vsukharew.multimodule.sample

import android.app.Application
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider
import vsukharew.multimodule.dagger.core.di.dependencies.HasDependencies

internal class CalendarSampleApp : Application(), HasDependencies {
    override val dependenciesProvider: DependenciesProvider = CalendarDependenciesProvider()
}