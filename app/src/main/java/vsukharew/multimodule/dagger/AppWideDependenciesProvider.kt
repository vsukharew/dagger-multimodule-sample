package vsukharew.multimodule.dagger

import android.content.Context
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.calendar.impl.di.component.CalendarApiComponent
import vsukharew.multimodule.dagger.core.di.component.DaggerCoreComponent
import vsukharew.multimodule.dagger.core.di.provider.AbstractDependenciesProvider
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.dependencies.calendar.DefaultCalendarDependencies
import vsukharew.multimodule.dagger.dependencies.mainmenu.DefaultMainMenuScreenDependencies
import vsukharew.multimodule.dagger.dependencies.order.DefaultOrderFlowScreenExternalDependencies
import vsukharew.multimodule.dagger.root.di.component.OrderApiComponent
import vsukharew.multimodule.dagger.root.di.dependencies.OrderFlowDependencies
import vsukharew.multimodule.main_menu.di.MainMenuScreenDependencies
import kotlin.reflect.KClass

class AppWideDependenciesProvider(private val context: Context) : AbstractDependenciesProvider() {

    override fun <T : Dependencies> createDependencies(
        dependenciesClass: KClass<T>,
    ): Dependencies? {
        val coreComponent = getOrCreateComponent { DaggerCoreComponent.create() }
        val router = coreComponent.router()
        val dependencies = when (dependenciesClass) {
            CalendarDependencies::class -> {
                DefaultCalendarDependencies(
                    router,
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
            OrderFlowDependencies::class -> {
                DefaultOrderFlowScreenExternalDependencies(
                    router,
                    coreComponent.profileRepo()
                )
            }
            else -> null
        }
        return dependencies
    }
}