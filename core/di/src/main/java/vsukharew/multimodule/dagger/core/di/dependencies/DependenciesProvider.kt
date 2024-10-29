package vsukharew.multimodule.dagger.core.di.dependencies

import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import kotlin.reflect.KClass

interface DependenciesProvider {
    val componentsStorage: MutableMap<KClass<*>, DaggerComponent>
    fun <T : Dependencies> getDependencies(dependenciesClass: KClass<T>): T
}

