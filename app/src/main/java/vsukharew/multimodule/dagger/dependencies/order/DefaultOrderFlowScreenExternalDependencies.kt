package vsukharew.multimodule.dagger.dependencies.order

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.root.di.dependencies.OrderFlowDependencies
import javax.inject.Inject

class DefaultOrderFlowScreenExternalDependencies @Inject constructor(
    override val router: Router,
    override val profileRepo: ProfileRepo,
) : OrderFlowDependencies