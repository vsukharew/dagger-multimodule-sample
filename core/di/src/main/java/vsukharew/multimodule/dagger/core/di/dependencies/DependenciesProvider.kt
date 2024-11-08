package vsukharew.multimodule.dagger.core.di.dependencies

import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import kotlin.reflect.KClass

interface DependenciesProvider {
    fun <T : DaggerComponent, C : KClass<T>> getOrCreateComponent(
        clazz: C,
        creationBlock: () -> T
    ): DaggerComponent

    fun <T : DaggerComponent, C : KClass<T>> releaseComponent(clazz: C)
    fun <T : DaggerComponent, C : KClass<T>> containsComponent(componentClass: C): Boolean
    fun <T : Dependencies, C : KClass<T>> getDependencies(dependenciesClass: C): Dependencies?
}