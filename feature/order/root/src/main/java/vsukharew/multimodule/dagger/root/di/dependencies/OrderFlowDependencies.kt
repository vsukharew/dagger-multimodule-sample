package vsukharew.multimodule.dagger.root.di.dependencies

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies

interface OrderFlowDependencies : Dependencies {
    val router: Router
    val profileRepo: ProfileRepo
}