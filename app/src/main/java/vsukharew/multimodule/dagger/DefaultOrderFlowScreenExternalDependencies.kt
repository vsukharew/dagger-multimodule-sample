package vsukharew.multimodule.dagger

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.order.impl.flow.di.OrderFlowScreenExternalDependencies

class DefaultOrderFlowScreenExternalDependencies(
    override val router: Router
) : OrderFlowScreenExternalDependencies