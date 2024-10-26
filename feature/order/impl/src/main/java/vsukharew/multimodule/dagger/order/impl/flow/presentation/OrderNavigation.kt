package vsukharew.multimodule.dagger.order.impl.flow.presentation

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.order.api.OrderRouter
import javax.inject.Inject

class OrderNavigation @Inject constructor(
    private val globalRouter: Router,
) : OrderRouter {

    override fun startOrderFlow() {
        globalRouter.navigateTo(OrderFlowScreen())
    }
}