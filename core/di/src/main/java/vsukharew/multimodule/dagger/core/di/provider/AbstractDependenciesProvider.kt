package vsukharew.multimodule.dagger.core.di.provider

import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import kotlin.reflect.KClass

abstract class AbstractDependenciesProvider : DependenciesProvider {
    private val componentsStorage: MutableMap<KClass<*>, DaggerComponent> = mutableMapOf()
    private val componentDependencies = mutableMapOf<KClass<out Dependencies>, Dependencies>()

    protected abstract fun <T : Dependencies> createDependencies(
        dependenciesClass: KClass<T>,
    ): Dependencies?

    override fun <T : Dependencies> getDependencies(
        dependenciesClass: KClass<T>
    ): T? {
        val dependencies = componentDependencies[dependenciesClass] ?: createDependencies(
            dependenciesClass
        )?.also { componentDependencies[dependenciesClass] = it }
        return dependencies as? T?
    }

    override fun <T : Dependencies> clearDependencies(dependenciesClass: KClass<T>) {
        componentDependencies.remove(dependenciesClass)
    }

    override fun <T : DaggerComponent, C : KClass<T>> getOrCreateComponent(
        clazz: C,
        creationBlock: () -> T
    ): T {
        return componentsStorage[clazz] as? T ?: creationBlock.invoke().also {
            componentsStorage[clazz] = it
        }
    }

    override fun <T : DaggerComponent, C : KClass<T>> releaseComponent(clazz: C) {
        componentsStorage.remove(clazz)
    }

    override fun <T : DaggerComponent, C : KClass<T>> containsComponent(componentClass: C): Boolean {
        return componentsStorage.containsKey(componentClass)
    }
}

