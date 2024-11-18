plugins {
    id("android-library-module-plugin")
}

android {
    namespace = "vsukharew.multimodule.core.impl"
}

dependencies {
    implementation(project(":core:api"))
}