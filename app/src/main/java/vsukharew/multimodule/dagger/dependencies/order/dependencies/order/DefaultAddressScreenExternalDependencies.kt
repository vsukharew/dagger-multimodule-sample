package vsukharew.multimodule.dagger.dependencies.order

import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenExternalDependencies
import javax.inject.Inject

class DefaultAddressScreenExternalDependencies @Inject constructor(
    private val calendarFeatureApi: CalendarFeatureApi,
) : AddressScreenExternalDependencies {
    override fun calendarFeatureApi(): CalendarFeatureApi = calendarFeatureApi
}