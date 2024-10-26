package vsukharew.multimodule.dagger.core.di

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class PerFeature

@Retention(AnnotationRetention.BINARY)
annotation class PerScreenRetained

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class PerScreen