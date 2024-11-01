package vsukharew.multimodule.dagger.root.di.provider.dependencies

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenDependencies

class DefaultAddressScreenDependencies(
    private val globalRouter: Router,
    @Flow private val flowRouter: Router,
    private val calendarFeatureApi: CalendarFeatureApi,
) : AddressScreenDependencies {
    override fun globalRouter(): Router = globalRouter
    override fun flowRouter(): Router = flowRouter
    override fun calendarFeatureApi(): CalendarFeatureApi = calendarFeatureApi
}