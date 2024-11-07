package vsukharew.multimodule.dagger.root.di.provider.dependencies.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vsukharew.multimodule.dagger.calendar.impl.di.CalendarDependencies
import vsukharew.multimodule.dagger.core.di.DependenciesKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import vsukharew.multimodule.dagger.root.di.provider.dependencies.data.DefaultCalendarFlowDependencies

@Module
internal interface CalendarScreenDependenciesModule {
    @Binds
    @IntoMap
    @DependenciesKey(CalendarDependencies::class)
    fun bindCalendarScreenDependencies(
        impl: DefaultCalendarFlowDependencies
    ): Dependencies
}