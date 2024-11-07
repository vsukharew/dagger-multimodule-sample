package vsukharew.multimodule.dagger.root.di.provider.dependencies.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.core.di.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.core.di.dependencies.InnerNavigationScreenDependencies
import vsukharew.multimodule.dagger.root.di.provider.dependencies.data.OrderInnerNavigationScreenDependencies

@Module
internal interface InnerNavigationDependenciesModule {
    @Binds
    @IntoMap
    @DependenciesKey(InnerNavigationScreenDependencies::class)
    fun bindInnerNavigationScreenDependencies(
        impl: OrderInnerNavigationScreenDependencies,
    ): Dependencies
}