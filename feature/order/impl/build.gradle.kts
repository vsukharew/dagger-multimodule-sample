@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.kotlin.gradle.plugin)
    id("kotlin-kapt")
}

android {
    namespace = "vsukharew.multimodule.dagger.order.impl"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:di"))
    implementation(project(":core:ui"))
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:order:api"))
    implementation(libs.android.core.ktx)
    implementation(libs.android.fragment.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.android.fragment.ktx)
    implementation(libs.dagger.library)
    kapt(libs.dagger.compiler)
    implementation(libs.cicerone)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}