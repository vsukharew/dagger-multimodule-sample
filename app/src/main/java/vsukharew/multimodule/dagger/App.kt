package vsukharew.multimodule.dagger

import android.app.Application
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider

class App : Application(), DependenciesProvider by AppWideDependenciesProvider()