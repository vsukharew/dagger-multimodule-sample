plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "vsukharew.multimodule.dagger"
    compileSdk = 34

    defaultConfig {
        applicationId = "vsukharew.multimodule.dagger"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
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
    implementation(libs.android.core.ktx)
    implementation(libs.android.fragment.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.constraint.layout)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.dagger.library)
    implementation(libs.cicerone)
    kapt(libs.dagger.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}