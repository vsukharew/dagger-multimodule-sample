package vsukharew.multimodule.dagger.core.di

import dagger.MapKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import kotlin.reflect.KClass

@MapKey
annotation class DependenciesKey(val value: KClass<out Dependencies>)