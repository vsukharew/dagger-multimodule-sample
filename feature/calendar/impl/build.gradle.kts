plugins {
    id("android-library-plugin")
}

android {
    namespace = "vsukharew.multimodule.calendar.impl"
}

dependencies {
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:order:api"))
    implementation(project(":core:api"))
    implementation(project(":core:di"))
}