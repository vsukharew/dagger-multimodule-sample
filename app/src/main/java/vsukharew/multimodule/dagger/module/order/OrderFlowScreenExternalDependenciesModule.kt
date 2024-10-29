package vsukharew.multimodule.dagger.module.order

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.dependencies.order.DefaultOrderFlowScreenExternalDependencies
import vsukharew.multimodule.dagger.module.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.order.impl.flow.di.OrderFlowScreenExternalDependencies

@Module
interface OrderFlowScreenExternalDependenciesModule {

    @Binds
    @IntoMap
    @DependenciesKey(OrderFlowScreenExternalDependencies::class)
    fun bindOrderFlowScreenExternalDependencies(
        impl: DefaultOrderFlowScreenExternalDependencies
    ): Dependencies
}