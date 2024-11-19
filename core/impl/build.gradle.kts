plugins {
    id("android-library-plugin")
}

android {
    namespace = "vsukharew.multimodule.core.impl"
}

dependencies {
    implementation(project(":core:api"))
}