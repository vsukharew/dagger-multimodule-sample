package vsukharew.multimodule.dagger.root.di.module

import dagger.Binds
import dagger.Module
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.order.api.OrderRouter
import vsukharew.multimodule.dagger.root.presentation.OrderNavigation

@Module
internal interface OrderApiModule {
    @Binds
    @PerFeature
    fun bindOrderFlowNavigation(navigation: OrderNavigation): OrderRouter
}