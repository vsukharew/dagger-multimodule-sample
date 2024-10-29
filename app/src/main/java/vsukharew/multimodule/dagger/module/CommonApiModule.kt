package vsukharew.multimodule.dagger.module

import dagger.Module
import vsukharew.multimodule.dagger.module.calendar.CalendarApiModule
import vsukharew.multimodule.dagger.module.order.OrderApiModule

@Module(
    includes = [
        CalendarApiModule::class,
        OrderApiModule::class,
    ]
)
class CommonApiModule