package vsukharew.multimodule.dagger.order.impl.address.di

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies

interface AddressScreenDependencies : Dependencies {
    fun globalRouter(): Router
    @Flow
    fun flowRouter(): Router
    fun calendarFeatureApi(): CalendarFeatureApi
}