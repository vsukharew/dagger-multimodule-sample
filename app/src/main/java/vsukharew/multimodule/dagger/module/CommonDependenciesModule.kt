package vsukharew.multimodule.dagger.module

import dagger.Module
import vsukharew.multimodule.dagger.module.calendar.CalendarDependenciesModule
import vsukharew.multimodule.dagger.module.mainmenu.MainMenuScreenDependenciesModule
import vsukharew.multimodule.dagger.module.order.OrderFlowScreenDependenciesModule

@Module(
    includes = [
        CalendarDependenciesModule::class,
        MainMenuScreenDependenciesModule::class,
        OrderFlowScreenDependenciesModule::class,
    ]
)
class CommonDependenciesModule