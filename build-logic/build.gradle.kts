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

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    implementation(libs.android.tools.gradle)
    implementation(libs.kotlin.gradle)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}