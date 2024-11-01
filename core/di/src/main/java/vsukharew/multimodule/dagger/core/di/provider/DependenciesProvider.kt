package vsukharew.multimodule.dagger.core.di.provider

import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import kotlin.reflect.KClass

interface DependenciesProvider {
    fun <T: DaggerComponent, C: KClass<T>> getOrCreateComponent(clazz: C, creationBlock: () -> T): T
    fun <T: DaggerComponent, C: KClass<T>> releaseComponent(clazz: C)
    fun <T : Dependencies> getDependencies(dependenciesClass: KClass<T>): T?
    fun <T : Dependencies> clearDependencies(dependenciesClass: KClass<T>)
}