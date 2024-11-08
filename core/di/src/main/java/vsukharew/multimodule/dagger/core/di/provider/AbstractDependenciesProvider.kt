package vsukharew.multimodule.dagger.core.di.provider

import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.component.DependenciesComponent
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider
import kotlin.reflect.KClass

abstract class AbstractDependenciesProvider : DependenciesProvider {
    private val componentsStorage: MutableMap<KClass<*>, DaggerComponent> = mutableMapOf()
    protected abstract val dependenciesComponent: DependenciesComponent

    override fun <T : Dependencies, C : KClass<T>> getDependencies(dependenciesClass: C): Dependencies? {
        return dependenciesComponent.dependencies[dependenciesClass.java]?.get()
    }

    override fun <T : DaggerComponent, C : KClass<T>> getOrCreateComponent(
        clazz: C,
        creationBlock: () -> T
    ): DaggerComponent {
        return componentsStorage[clazz] ?: creationBlock.invoke().also {
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

