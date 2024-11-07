package vsukharew.multimodule.dagger.root.di.provider

import vsukharew.multimodule.dagger.core.di.component.DependenciesComponent
import vsukharew.multimodule.dagger.core.di.provider.AbstractDependenciesProvider
import vsukharew.multimodule.dagger.root.di.component.OrderFlowScreenComponent
import vsukharew.multimodule.dagger.root.di.provider.component.DaggerOrderFlowDependenciesComponent

internal class OrderFlowDependenciesProvider(
    private val orderFlowScreenComponent: OrderFlowScreenComponent
) : AbstractDependenciesProvider() {

    override val dependenciesComponent: DependenciesComponent by lazy {
        orderFlowScreenComponent.run {
            DaggerOrderFlowDependenciesComponent.factory()
                .create(
                    router(),
                    flowRouter(),
                    profileRepo()
                )
        }
    }
}