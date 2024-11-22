package extensions

import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.Installation
import com.android.build.api.dsl.ProductFlavor
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

typealias AndroidExtension = CommonExtension<
        out BuildFeatures,
        out BuildType,
        out DefaultConfig,
        out ProductFlavor,
        out AndroidResources,
        out Installation>

internal inline fun Project.generalAndroid(block: AndroidExtension.() -> Unit) {
    extensions.run {
        findByType<BaseAppModuleExtension>() ?: findByType<LibraryExtension>()
    }?.let { block.invoke(it) }
}

internal fun Project.java(configure: JavaPluginExtension.() -> Unit) {
    extensions.configure<JavaPluginExtension>(configure)
}

internal fun Project.kotlinCompilerOptions(block: KotlinProjectExtension.() -> Unit) {
    extensions.configure<KotlinProjectExtension>(block::invoke)
}

internal val Project.libs: LibrariesForLibs
    get() = the()