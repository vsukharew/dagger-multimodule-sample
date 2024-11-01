package vsukharew.multimodule.dagger.root.di.provider

import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.calendar.impl.di.component.CalendarApiComponent
import vsukharew.multimodule.dagger.core.di.provider.AbstractDependenciesProvider
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.dependencies.InnerNavigationScreenDependencies
import vsukharew.multimodule.dagger.core.di.utils.getOrCreateComponent
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenDependencies
import vsukharew.multimodule.dagger.root.di.component.OrderFlowScreenComponent
import vsukharew.multimodule.dagger.root.di.provider.dependencies.DefaultAddressScreenDependencies
import vsukharew.multimodule.dagger.root.di.provider.dependencies.DefaultCalendarFlowDependencies
import vsukharew.multimodule.dagger.root.di.provider.dependencies.OrderInnerNavigationScreenDependencies
import kotlin.reflect.KClass

internal class OrderFlowDependenciesProvider(
    private val orderFlowScreenComponent: OrderFlowScreenComponent
) : AbstractDependenciesProvider() {
    override fun <T : Dependencies> createDependencies(
        dependenciesClass: KClass<T>,
    ): Dependencies? {
        return orderFlowScreenComponent.run {
            when (dependenciesClass) {
                AddressScreenDependencies::class -> {
                    val calendarFeatureApi =
                        getOrCreateComponent { CalendarApiComponent.build(flowRouter()) }
                    DefaultAddressScreenDependencies(
                        router(),
                        flowRouter(),
                        calendarFeatureApi
                    )
                }
                InnerNavigationScreenDependencies::class -> {
                    OrderInnerNavigationScreenDependencies(
                        router(),
                        flowRouter()
                    )
                }
                CalendarDependencies::class -> {
                    DefaultCalendarFlowDependencies(
                        flowRouter(),
                        profileRepo(),
                    )
                }
                else -> null
            }
        }
    }
}