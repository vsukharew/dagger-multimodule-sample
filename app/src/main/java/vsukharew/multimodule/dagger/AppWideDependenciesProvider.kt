package vsukharew.multimodule.dagger

import vsukharew.multimodule.dagger.calendar.impl.di.component.CalendarApiComponent
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.core.di.component.DaggerCoreComponent
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.dependencies.DependenciesProvider
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.order.impl.di.OrderApiComponent
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenExternalDependencies
import vsukharew.multimodule.dagger.order.impl.flow.di.OrderFlowScreenExternalDependencies
import vsukharew.multimodule.main_menu.di.MainMenuScreenDependencies
import kotlin.reflect.KClass

class AppWideDependenciesProvider : DependenciesProvider {
    private val componentDependencies = mutableMapOf<KClass<out Dependencies>, Dependencies>()

    override val componentsStorage: MutableMap<KClass<*>, DaggerComponent> = mutableMapOf()

    override fun <T : Dependencies> getDependencies(dependenciesClass: KClass<T>): T {
        val dependencies = componentDependencies[dependenciesClass]
            ?: createDependencies(componentDependencies, dependenciesClass)
        return dependencies as T
    }

    override fun <T : Dependencies> clearDependencies(dependenciesClass: KClass<T>) {
        componentDependencies.remove(dependenciesClass)
    }

    private fun <T : Dependencies> createDependencies(
        componentDependencies: MutableMap<KClass<out Dependencies>, Dependencies>,
        dependenciesClass: KClass<T>,
    ): Dependencies {
        val coreComponent = getOrCreateComponent { DaggerCoreComponent.create() }
        val router = coreComponent.router()
        val dependencies = when (dependenciesClass) {
            CalendarDependencies::class -> {
                DefaultCalendarDependencies(
                    router,
                    getOrCreateComponent { OrderApiComponent.build(router) },
                    coreComponent.profileRepo()
                )
            }

            MainMenuScreenDependencies::class -> {
                DefaultMainMenuScreenDependencies(
                    router,
                    getOrCreateComponent { OrderApiComponent.build(router) },
                    getOrCreateComponent { CalendarApiComponent.build(router) }
                )
            }

            AddressScreenExternalDependencies::class -> {
                DefaultAddressScreenExternalDependencies(
                    getOrCreateComponent { CalendarApiComponent.build(router) }
                )
            }

            OrderFlowScreenExternalDependencies::class -> {
                DefaultOrderFlowScreenExternalDependencies(
                    router
                )
            }

            else -> throw Exception()
        }
        return dependencies.also { componentDependencies[dependenciesClass] = it }
    }
}