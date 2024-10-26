package vsukharew.multimodule.dagger.order.impl.address.di

import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies

interface AddressScreenExternalDependencies : Dependencies {
    fun calendarFeatureApi(): CalendarFeatureApi
}