package vsukharew.multimodule.dagger.order.impl.di

import dagger.Binds
import dagger.Module
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.order.api.OrderRouter
import vsukharew.multimodule.dagger.order.impl.flow.presentation.OrderNavigation

@Module
interface OrderApiModule {
    @Binds
    @PerFeature
    fun bindOrderFlowNavigation(navigation: OrderNavigation): OrderRouter
}