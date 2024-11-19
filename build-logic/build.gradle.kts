import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

val Project.libs
    get() = extensions.getByType<LibrariesForLibs>()

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

group = "vsukharew.dagger.multimodule.buildlogic"

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

gradlePlugin {
    plugins {
        register("android-application-plugin") {
            id = "android-application-plugin"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("android-library-plugin") {
            id = "android-library-plugin"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("kotlin-module-plugin") {
            id = "kotlin-module-plugin"
            implementationClass = "KotlinModulePlugin"
        }
    }
}

dependencies {
    implementation(libs.android.tools.gradle)
    implementation(libs.kotlin.gradle)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}