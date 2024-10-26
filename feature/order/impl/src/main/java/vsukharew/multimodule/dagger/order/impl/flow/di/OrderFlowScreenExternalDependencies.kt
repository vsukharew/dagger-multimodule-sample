package vsukharew.multimodule.dagger.order.impl.flow.di

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies

interface OrderFlowScreenExternalDependencies : Dependencies {
    val router: Router
}