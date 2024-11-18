pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "dagger-multimodule-sample"
include(":app")
include(":core:api")
include(":core:impl")
include(":feature:calendar")
include(":feature:calendar:api")
include(":feature:calendar:impl")
include(":main-menu")
include(":core:di")
include(":feature:order:api")
include(":feature:order:impl")
include(":core:ui")
include(":feature:order:root")
include(":feature:calendar:sample")