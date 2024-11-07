package vsukharew.multimodule.dagger.root.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.PerFeature

@Module
internal object InnerNavigationModule {
    @Provides
    @PerFeature
    @Flow
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @PerFeature
    @Flow
    fun provideRouter(@Flow cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    @PerFeature
    @Flow
    fun provideNavigationHolder(@Flow cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()
}