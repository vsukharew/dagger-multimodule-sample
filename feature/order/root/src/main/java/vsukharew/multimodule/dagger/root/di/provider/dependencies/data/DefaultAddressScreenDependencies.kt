package vsukharew.multimodule.dagger.root.di.provider.dependencies.data

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.api.CalendarFeatureApi
import vsukharew.multimodule.dagger.core.di.Flow
import vsukharew.multimodule.dagger.core.di.PerFeature
import vsukharew.multimodule.dagger.order.impl.address.di.AddressScreenDependencies
import javax.inject.Inject

@PerFeature
class DefaultAddressScreenDependencies @Inject constructor(
    private val globalRouter: Router,
    @Flow private val flowRouter: Router,
    private val calendarFeatureApi: CalendarFeatureApi,
) : AddressScreenDependencies {
    override fun globalRouter(): Router = globalRouter
    override fun flowRouter(): Router = flowRouter
    override fun calendarFeatureApi(): CalendarFeatureApi = calendarFeatureApi
}