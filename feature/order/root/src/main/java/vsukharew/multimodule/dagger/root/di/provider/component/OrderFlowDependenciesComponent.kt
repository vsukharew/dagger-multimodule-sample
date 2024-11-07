package vsukharew.multimodule.dagger.root.di.provider.component

import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.core.di.component.DependenciesComponent
import vsukharew.multimodule.dagger.root.di.provider.dependencies.module.AddressScreenDependenciesModule
import vsukharew.multimodule.dagger.root.di.provider.dependencies.module.CalendarScreenDependenciesModule
import vsukharew.multimodule.dagger.root.di.provider.dependencies.module.OrderFlowCalendarApiModule
import vsukharew.multimodule.dagger.root.di.provider.dependencies.module.InnerNavigationDependenciesModule

@Component(
    modules = [
        AddressScreenDependenciesModule::class,
        CalendarScreenDependenciesModule::class,
        InnerNavigationDependenciesModule::class,
        OrderFlowCalendarApiModule::class,
    ],
)
@PerFeature
internal interface OrderFlowDependenciesComponent : DependenciesComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance globalRouter: Router,
            @BindsInstance @Flow flowRouter: Router,
            @BindsInstance profileRepo: ProfileRepo,
        ): OrderFlowDependenciesComponent
    }
}