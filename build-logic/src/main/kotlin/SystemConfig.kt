import org.gradle.api.JavaVersion

object SystemConfig {
    const val COMPILE_SDK = DefaultConfig.TARGET_SDK

    object DefaultConfig {
        const val MIN_SDK = 24
        const val TARGET_SDK = 34
        const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

        object VectorDrawables {
            const val USE_SUPPORT_LIBRARY = true
        }
    }

    object CompileOptions {
        val sourceCompatibility = JavaVersion.VERSION_21
        val targetCompatibility = sourceCompatibility
    }

    object KotlinOptions {
        const val TOOLCHAIN_JDK_VERSION = 21
    }

    object BuildFeatures {
        const val IS_VIEW_BINDING_ENABLED = true
    }

    object Packaging {
        object Resources {
            const val EXCLUDES = "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}