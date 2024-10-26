package vsukharew.multimodule.dagger.order.impl.address.di

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.core.di.Flow

interface AddressScreenInternalDependencies {
    fun globalRouter(): Router
    @Flow
    fun flowRouter(): Router
}