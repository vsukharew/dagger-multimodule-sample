plugins {
    id("android-application-plugin")
}

android {
    namespace = "vsukharew.multimodule.dagger"
}

dependencies {
    implementation(project(":main-menu"))
    implementation(project(":core:api"))
    implementation(project(":core:di"))
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:calendar:impl"))
    implementation(project(":feature:order:api"))
    implementation(project(":feature:order:impl"))
    implementation(project(":feature:order:root"))
    debugImplementation(libs.leakCanary)
}