plugins {
    id("android-library-module-plugin")
}

android {
    namespace = "vsukharew.multimodule.dagger.order.impl"
}

dependencies {
    implementation(project(":core:di"))
    implementation(project(":core:ui"))
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:order:api"))
}