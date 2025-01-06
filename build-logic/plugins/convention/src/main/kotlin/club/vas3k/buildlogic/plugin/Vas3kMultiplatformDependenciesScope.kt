package club.vas3k.buildlogic.plugin

import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

open class Vas3kMultiplatformDependenciesScope(
    handler: KotlinDependencyHandler
) : KotlinDependencyHandler by handler
