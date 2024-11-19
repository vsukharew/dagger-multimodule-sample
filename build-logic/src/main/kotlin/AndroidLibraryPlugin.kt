import extensions.libs
import utils.applyGeneralAndroidModulePlugins
import utils.configureGeneralAndroidModuleOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import utils.configureGeneralAndroidModuleDependencies

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.android.library.get().pluginId)
                applyGeneralAndroidModulePlugins()
            }
            configureGeneralAndroidModuleOptions()
            configureGeneralAndroidModuleDependencies()
        }
    }
}