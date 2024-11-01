package vsukharew.multimodule.dagger.root.di.provider.dependencies

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.dependencies.InnerNavigationScreenDependencies

internal class OrderInnerNavigationScreenDependencies(
    private val globalRouter: Router,
    @Flow private val flowRouter: Router,
) : InnerNavigationScreenDependencies {
    override fun globalRouter() = globalRouter
    override fun flowRouter() = flowRouter
}