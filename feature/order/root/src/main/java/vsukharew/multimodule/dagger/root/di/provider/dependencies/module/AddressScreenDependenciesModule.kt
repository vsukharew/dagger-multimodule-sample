package vsukharew.multimodule.dagger.root.di.provider.dependencies.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.core.di.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenDependencies
import vsukharew.multimodule.dagger.root.di.provider.dependencies.data.DefaultAddressScreenDependencies

@Module
internal interface AddressScreenDependenciesModule {
    @Binds
    @IntoMap
    @DependenciesKey(AddressScreenDependencies::class)
    fun bindAddressScreenDependencies(
        impl: DefaultAddressScreenDependencies
    ): Dependencies
}