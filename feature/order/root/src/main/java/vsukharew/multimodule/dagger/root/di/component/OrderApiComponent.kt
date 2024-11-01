package vsukharew.multimodule.dagger.root.di.component

import com.github.terrakok.cicerone.Router
import dagger.Component
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.core.di.component.DaggerComponent
import vsukharew.multimodule.dagger.order.api.OrderFeatureApi
import vsukharew.multimodule.dagger.root.di.module.OrderApiModule

@PerFeature
@Component(modules = [OrderApiModule::class], dependencies = [Router::class])
interface OrderApiComponent : OrderFeatureApi, DaggerComponent {

    companion object {
        fun build(router: Router): OrderApiComponent {
            return DaggerOrderApiComponent.builder()
                .router(router)
                .build()
        }
    }
}