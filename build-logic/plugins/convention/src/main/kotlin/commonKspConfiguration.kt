@file:Suppress("Filename")

import org.gradle.api.Project

fun Project.includeCommonKspConfigurationTo(
    vararg toConfigurations: String,
) {
    pluginManager.withPlugin("com.google.devtools.ksp") {
        val commonKsp = configurations.create("commonKsp")
        toConfigurations.forEach { configurationName ->
            configurations.getByName(configurationName).extendsFrom(commonKsp)
        }
    }
}


fun Project.includeAllKspConfiguration() = includeCommonKspConfigurationTo(
    "kspAndroid",
    "kspDesktop",
    "kspWasmJs",
    "kspCommonMainMetadata",
    "kspIosX64",
    "kspIosArm64",
    "kspIosSimulatorArm64"
)