plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.kotlin.gradle.plugin)
    id("kotlin-kapt")
}

android {
    namespace = "vsukharew.multimodule.impl_root"
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
}

dependencies {
    implementation(project(":core:api"))
    implementation(project(":core:di"))
    implementation(project(":core:ui"))
    implementation(project(":feature:calendar:api"))
    implementation(project(":feature:calendar:impl"))
    implementation(project(":feature:order:api"))
    implementation(project(":feature:order:impl"))
    implementation(libs.android.core.ktx)
    implementation(libs.android.fragment.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.dagger.library)
    implementation(libs.cicerone)
    kapt(libs.dagger.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}