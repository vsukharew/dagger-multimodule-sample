import extensions.libs
import extensions.java
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.java.library.get().pluginId)
                apply(libs.plugins.kotlin.jvm.get().pluginId)
            }
            java {
                sourceCompatibility = SystemConfig.CompileOptions.sourceCompatibility
                targetCompatibility = SystemConfig.CompileOptions.targetCompatibility
            }
        }
    }
}