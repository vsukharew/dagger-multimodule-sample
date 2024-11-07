package vsukharew.multimodule.dagger

import android.content.Context
import vsukharew.multimodule.dagger.component.DaggerAppDependenciesComponent
import vsukharew.multimodule.dagger.core.di.component.DaggerCoreComponent
import vsukharew.multimodule.dagger.core.di.component.DependenciesComponent
import vsukharew.multimodule.dagger.core.di.provider.AbstractDependenciesProvider
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent

class AppWideDependenciesProvider(private val context: Context) : AbstractDependenciesProvider() {
    override val dependenciesComponent: DependenciesComponent by lazy {
        getOrCreateComponent { DaggerCoreComponent.create() }.run {
            DaggerAppDependenciesComponent.builder()
                .router(router())
                .profileRepo(profileRepo())
                .build()
        }
    }
}