plugins {
    id("android-app-module-plugin")
}

android {
    namespace = "vsukharew.multimodule.sample"
}

dependencies {
    implementation(project(":core:api"))
    implementation(project(":core:di"))
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:calendar:impl"))
}