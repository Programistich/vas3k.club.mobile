package club.vas3k.buildlogic

import club.vas3k.buildlogic.model.FlavorType
import org.gradle.api.Project

object ApkConfig {
    const val APPLICATION_ID = "club.vas3k.app"

    const val MIN_SDK_VERSION = 26

    const val TARGET_SDK_VERSION = 35
    const val COMPILE_SDK_VERSION = 35

    val Project.VERSION_CODE
        get() = prop("version_code", 1).toInt()
    val Project.VERSION_NAME
        get() = prop("version_name", "1.0.$VERSION_CODE")

    val Project.CURRENT_FLAVOR_TYPE: FlavorType
        get() {
            val default = FlavorType.DEV
            val key = "current_flavor_type"
            val propValue = propOrNull(key)
            if (propValue == null) {
                logger.warn("Property $key was not found, writing default $default")
            }
            return FlavorType.values().find { it.name == propValue } ?: default
        }
}

internal fun Project.propOrNull(key: String): String? {
    return providers.gradleProperty(key).orNull
}

internal fun Project.prop(key: String, default: Any): String {
    return providers.gradleProperty(key).getOrElse(default.toString())
}
