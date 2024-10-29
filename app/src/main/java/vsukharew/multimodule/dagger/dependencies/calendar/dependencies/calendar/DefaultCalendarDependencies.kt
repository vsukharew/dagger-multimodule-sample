package vsukharew.multimodule.dagger.dependencies.calendar

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo

import vsukharew.multimodule.dagger.order.api.OrderFeatureApi
import javax.inject.Inject

class DefaultCalendarDependencies @Inject constructor(
    override val router: Router,
    override val orderFeatureApi: OrderFeatureApi,
    override val profileRepo: ProfileRepo,
) : CalendarDependencies