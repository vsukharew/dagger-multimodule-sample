package vsukharew.multimodule.dagger.core.impl.data

import vsukharew.multimodule.dagger.core.api.data.ProfileRepo
import java.util.UUID
import javax.inject.Inject

class ProfileRepository @Inject constructor() : ProfileRepo {
    override fun getProfileId(): String = UUID.randomUUID().toString()
}