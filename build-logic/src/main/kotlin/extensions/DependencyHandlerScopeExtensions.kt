package extensions

import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun DependencyHandlerScope.implementation(dependency: Provider<*>) {
    add("implementation", dependency)
}

internal fun DependencyHandlerScope.testImplementation(dependency: Provider<*>) {
    add("testImplementation", dependency)
}

internal fun DependencyHandlerScope.androidTestImplementation(dependency: Provider<*>) {
    add("androidTestImplementation", dependency)
}

internal fun DependencyHandlerScope.kapt(dependency: Provider<*>) {
    add("kapt", dependency)
}

internal fun DependencyHandlerScope.debugImplementation(dependency: Provider<*>) {
    add("debugImplementation", dependency)
}