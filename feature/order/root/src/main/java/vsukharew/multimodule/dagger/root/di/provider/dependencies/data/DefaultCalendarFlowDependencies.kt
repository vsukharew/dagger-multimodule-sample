package vsukharew.multimodule.dagger.root.di.provider.dependencies.data

import com.github.terrakok.cicerone.Router
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.di.Flow
import javax.inject.Inject

class DefaultCalendarFlowDependencies @Inject constructor(
    @Flow override val router: Router,
    override val profileRepo: ProfileRepo
) : CalendarDependencies