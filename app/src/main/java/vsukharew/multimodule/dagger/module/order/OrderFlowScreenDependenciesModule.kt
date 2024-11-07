package vsukharew.multimodule.dagger.module.order

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.dependencies.order.DefaultOrderFlowScreenExternalDependencies
import vsukharew.multimodule.dagger.core.di.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.root.di.dependencies.OrderFlowDependencies

@Module
interface OrderFlowScreenDependenciesModule {

    @Binds
    @IntoMap
    @DependenciesKey(OrderFlowDependencies::class)
    fun bindOrderFlowScreenExternalDependencies(
        impl: DefaultOrderFlowScreenExternalDependencies
    ): Dependencies
}