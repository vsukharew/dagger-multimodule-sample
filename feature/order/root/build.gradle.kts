plugins {
    id("android-library-module-plugin")
}

android {
    namespace = "vsukharew.multimodule.impl_root"
}

dependencies {
    implementation(project(":core:api"))
    implementation(project(":core:di"))
    implementation(project(":core:ui"))
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:calendar:impl"))
    implementation(project(":feature:order:api"))
    implementation(project(":feature:order:impl"))
}