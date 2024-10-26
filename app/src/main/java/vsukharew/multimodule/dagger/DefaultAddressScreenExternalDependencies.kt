package vsukharew.multimodule.dagger

import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenExternalDependencies

class DefaultAddressScreenExternalDependencies(
    private val calendarFeatureApi: CalendarFeatureApi,
) : AddressScreenExternalDependencies {
    override fun calendarFeatureApi(): CalendarFeatureApi = calendarFeatureApi
}