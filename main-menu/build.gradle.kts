plugins {
    id("android-library-module-plugin")
}

android {
    namespace = "vsukharew.multimodule.main_menu"
}

dependencies {
    implementation(project(":core:di"))
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:order:api"))
}