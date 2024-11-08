package vsukharew.multimodule.dagger.core.di.provider

import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import kotlin.reflect.KClass

interface DependenciesProvider {
    fun <T : DaggerComponent, C : KClass<T>> getOrCreateComponent(
        clazz: C,
        creationBlock: () -> T
    ): DaggerComponent

    fun <T : DaggerComponent, C : KClass<T>> releaseComponent(clazz: C)
    fun <T : DaggerComponent, C : KClass<T>> containsComponent(componentClass: C): Boolean
    fun <T : Dependencies> getDependencies(dependenciesClass: KClass<T>): Dependencies?
    fun <T : Dependencies> clearDependencies(dependenciesClass: KClass<T>)
}