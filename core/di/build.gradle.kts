plugins {
    id("android-library-plugin")
}

android {
    namespace = "vsukharew.multimodule.dagger.core.di"
}

dependencies {
    implementation(project(":core:api"))
    implementation(project(":core:impl"))
    implementation(project(":core:ui"))
}