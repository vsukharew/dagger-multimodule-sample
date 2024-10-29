package vsukharew.multimodule.dagger.dependencies.order

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.order.impl.flow.di.OrderFlowScreenExternalDependencies
import javax.inject.Inject

class DefaultOrderFlowScreenExternalDependencies @Inject constructor(
    override val router: Router
) : OrderFlowScreenExternalDependencies