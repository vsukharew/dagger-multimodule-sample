import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import utils.android
import utils.applyGeneralAndroidModulePlugins
import utils.configureGeneralAndroidModuleOptions
import utils.configureGeneralAndroidModuleDependencies
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.android.application.get().pluginId)
                applyGeneralAndroidModulePlugins()
            }
            configureGeneralAndroidModuleOptions()
            android<BaseAppModuleExtension> {
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
            configureGeneralAndroidModuleDependencies()
        }
    }
}