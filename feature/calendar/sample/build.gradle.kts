plugins {
    alias(libs.plugins.android.gradle.plugin)
    alias(libs.plugins.kotlin.gradle.plugin)
    id("kotlin-kapt")
}

android {
    namespace = "vsukharew.multimodule.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "vsukharew.multimodule.sample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core:api"))
    implementation(project(":core:di"))
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:calendar:impl"))
    implementation(libs.android.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraint.layout)
    implementation(libs.cicerone)
    implementation(libs.dagger.library)
    kapt(libs.dagger.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}