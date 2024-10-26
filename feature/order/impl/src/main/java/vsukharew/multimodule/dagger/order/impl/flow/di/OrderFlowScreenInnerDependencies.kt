package vsukharew.multimodule.dagger.order.impl.flow.di

import vsukharew.multimodule.dagger.core.di.dependencies.InnerNavigationScreenDependencies

internal class OrderFlowScreenInnerDependencies(
    private val orderFlowScreenComponent: OrderFlowScreenComponent,
) : InnerNavigationScreenDependencies {
    override fun globalRouter() = orderFlowScreenComponent.router()
    override fun flowRouter() = orderFlowScreenComponent.flowRouter()
}