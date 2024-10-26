package vsukharew.multimodule.dagger.core.di.dependencies

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.di.Flow

interface InnerNavigationScreenDependencies : Dependencies {
    fun globalRouter(): Router
    @Flow
    fun flowRouter(): Router
}