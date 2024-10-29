package vsukharew.multimodule.dagger.module

import dagger.Module
import vsukharew.multimodule.dagger.module.calendar.CalendarDependenciesModule
import vsukharew.multimodule.dagger.module.mainmenu.MainMenuScreenDependenciesModule
import vsukharew.multimodule.dagger.module.order.AddressScreenExternalDependenciesModule
import vsukharew.multimodule.dagger.module.order.OrderFlowScreenExternalDependenciesModule

@Module(
    includes = [
        CalendarDependenciesModule::class,
        MainMenuScreenDependenciesModule::class,
        OrderFlowScreenExternalDependenciesModule::class,
        AddressScreenExternalDependenciesModule::class
    ]
)
class CommonDependenciesModule