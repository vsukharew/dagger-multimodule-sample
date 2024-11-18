plugins {
    id("com.android.application")
    id("android-module-plugin")
}

android {
    defaultConfig {
        targetSdk = SystemConfig.DefaultConfig.TARGET_SDK
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
}