plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = SystemConfig.CompileOptions.sourceCompatibility
    targetCompatibility = SystemConfig.CompileOptions.targetCompatibility
}