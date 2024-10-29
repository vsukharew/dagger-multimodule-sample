package vsukharew.multimodule.dagger.module.order

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.dependencies.order.DefaultAddressScreenExternalDependencies
import vsukharew.multimodule.dagger.module.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenExternalDependencies

@Module
interface AddressScreenExternalDependenciesModule {
    @Binds
    @IntoMap
    @DependenciesKey(AddressScreenExternalDependencies::class)
    fun bindAddressScreenExternalDependencies(
        impl: DefaultAddressScreenExternalDependencies
    ): Dependencies
}