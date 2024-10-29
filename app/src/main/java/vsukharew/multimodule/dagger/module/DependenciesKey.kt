package vsukharew.multimodule.dagger.module

import dagger.MapKey
import vsukharew.multimodule.dagger.core.di.dependencies.Dependencies
import kotlin.reflect.KClass

@MapKey
internal annotation class DependenciesKey(val value: KClass<out Dependencies>)