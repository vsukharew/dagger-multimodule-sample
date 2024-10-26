package vsukharew.multimodule.dagger.core.di.module

import dagger.Binds
import dagger.Module
import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import vsukharew.multimodule.dagger.core.impl.data.ProfileRepository
import javax.inject.Singleton

@Module
interface CoreModule {

    @Binds
    @Singleton
    fun bindProfileRepo(impl: ProfileRepository): ProfileRepo
}