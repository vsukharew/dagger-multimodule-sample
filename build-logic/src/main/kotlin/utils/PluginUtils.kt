package utils

import extensions.AndroidExtension
import extensions.androidTestImplementation
import extensions.generalAndroid
import extensions.implementation
import extensions.kapt
import extensions.kotlinCompilerOptions
import extensions.libs
import extensions.testImplementation
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.platform.base.ProjectDependencySpec
import org.gradle.plugin.use.PluginDependenciesSpec

internal fun Project.applyGeneralAndroidModulePlugins() {
    with(pluginManager) {
        apply(libs.plugins.kotlin.android.get().pluginId)
        apply(libs.plugins.kotlin.kapt.get().pluginId)
    }
}

internal fun Project.configureGeneralAndroidModuleOptions() {
    generalAndroid {
        compileSdk = SystemConfig.COMPILE_SDK

        defaultConfig {
            minSdk = SystemConfig.DefaultConfig.MIN_SDK
            testInstrumentationRunner = SystemConfig.DefaultConfig.TEST_INSTRUMENTATION_RUNNER
            vectorDrawables {
                useSupportLibrary = SystemConfig.DefaultConfig.VectorDrawables.USE_SUPPORT_LIBRARY
            }
        }

        compileOptions {
            sourceCompatibility = SystemConfig.CompileOptions.sourceCompatibility
            targetCompatibility = SystemConfig.CompileOptions.targetCompatibility
        }

        buildFeatures {
            viewBinding = SystemConfig.BuildFeatures.IS_VIEW_BINDING_ENABLED
        }

        packaging {
            resources {
                excludes += SystemConfig.Packaging.Resources.EXCLUDES
            }
        }
    }
    kotlinCompilerOptions {
        jvmToolchain(SystemConfig.KotlinOptions.TOOLCHAIN_JDK_VERSION)
    }
}

internal fun Project.configureGeneralAndroidModuleDependencies() {
    dependencies {
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
}

internal inline fun <reified T : AndroidExtension> Project.android(block: T.() -> Unit) {
    generalAndroid { block.invoke(this as T) }
}