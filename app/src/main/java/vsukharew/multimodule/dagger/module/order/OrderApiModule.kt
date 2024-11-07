package vsukharew.multimodule.dagger.module.order

import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import vsukharew.multimodule.dagger.order.api.OrderFeatureApi
import vsukharew.multimodule.dagger.root.di.component.OrderApiComponent
import javax.inject.Singleton

@Module
object OrderApiModule {

    @Provides
    @Singleton
    fun provideOrderApi(
        router: Router
    ): OrderFeatureApi = OrderApiComponent.build(router)
}