package vsukharew.multimodule.dagger.root.di.provider.dependencies.data

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.dependencies.InnerNavigationScreenDependencies
import javax.inject.Inject

internal class OrderInnerNavigationScreenDependencies @Inject constructor(
    private val globalRouter: Router,
    @Flow private val flowRouter: Router,
) : InnerNavigationScreenDependencies {
    override fun globalRouter() = globalRouter
    override fun flowRouter() = flowRouter
}