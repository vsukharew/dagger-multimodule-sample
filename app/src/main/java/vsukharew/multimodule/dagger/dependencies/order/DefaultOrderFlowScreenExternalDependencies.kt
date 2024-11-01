package vsukharew.multimodule.dagger.dependencies.order

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.root.di.dependencies.OrderFlowDependencies

class DefaultOrderFlowScreenExternalDependencies(
    override val router: Router,
    override val profileRepo: ProfileRepo,
) : OrderFlowDependencies