package vsukharew.multimodule.dagger

import vsukharew.multimodule.dagger.component.DaggerFeaturesDependenciesComponent
import vsukharew.multimodule.dagger.component.FeaturesDependenciesComponent
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.component.DaggerCoreComponent
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import kotlin.reflect.KClass

class AppWideDependenciesProvider : DependenciesProvider {
    private val featuresDependenciesComponent: FeaturesDependenciesComponent by lazy {
        getOrCreateComponent { DaggerCoreComponent.create() }.run {
            DaggerFeaturesDependenciesComponent.builder()
                .router(router())
                .profileRepo(profileRepo())
                .build()
        }
    }

    override val componentsStorage: MutableMap<KClass<*>, DaggerComponent> = mutableMapOf()

    override fun <T : Dependencies> getDependencies(dependenciesClass: KClass<T>): T {
        return featuresDependenciesComponent.dependencies[dependenciesClass.java]?.get() as? T
            ?: throw IllegalArgumentException()
    }
}