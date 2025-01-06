import club.vas3k.buildlogic.ApkConfig.VERSION_NAME
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    id("vas3k.android-app")
    id("vas3k.multiplatform-dependencies")
}

android.namespace = "club.vas3k.app"

kotlin {
    wasmJs {
        moduleName = "vas3k"
        browser {
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true

            export(libs.decompose)
            export(libs.essenty.lifecycle)
            export(libs.settings)
        }
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.timber)

            implementation(projects.components.core.activityholder)
            implementation(libs.androidx.appcompat)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.settings)

            implementation(libs.kotlin.inject.runtime)
            implementation(libs.kotlin.inject.anvil.runtime)
            implementation(libs.kotlin.inject.anvil.runtime.optional)

            implementation(libs.decompose)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.decompose.composeExtension)

            implementation(libs.kotlin.coroutines.swing)
        }
        iosMain.dependencies {
            api(libs.decompose)
            api(libs.essenty.lifecycle)
            api(libs.settings)

            implementation(libs.settings.observable)
        }
        wasmJsMain.dependencies {
            implementation(libs.settings.observable)
            implementation(libs.kotlin.serialization.json)
        }
    }
}

compose.desktop {
    application {
        mainClass = "club.vas3k.app.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Vas3k Mobile"
            packageVersion = VERSION_NAME
            vendor = "Community"

            macOS {
                dockName = "Vas3k"
                iconFile.set(project.file("icons/icon.icns"))
            }
            windows {
                iconFile.set(project.file("icons/icon.ico"))
            }
            linux {
                iconFile.set(project.file("icons/icon.png"))
            }
        }
    }
}

commonDependencies {
    implementation(projects.components.core.di)
    implementation(projects.components.core.log)
    implementation(projects.components.core.ktx)
    implementation(projects.components.core.ui.decompose)
    implementation(projects.components.core.ui.lifecycle)

    implementation(projects.components.vas3k.core.theme)

    implementation(projects.components.vas3k.root.api)
    implementation(projects.components.vas3k.root.impl)
    implementation(projects.components.vas3k.preference.api)
    implementation(projects.components.vas3k.preference.impl)
}

dependencies {
    add("kspCommonMainMetadata", libs.kotlin.inject.ksp)
    add("kspAndroid", libs.kotlin.inject.ksp)
    add("kspIosArm64", libs.kotlin.inject.ksp)
    add("kspIosX64", libs.kotlin.inject.ksp)
    add("kspIosSimulatorArm64", libs.kotlin.inject.ksp)
    add("kspDesktop", libs.kotlin.inject.ksp)
    add("kspWasmJs", libs.kotlin.inject.ksp)

    add("kspCommonMainMetadata", libs.kotlin.inject.anvil.ksp)
    add("kspAndroid", libs.kotlin.inject.anvil.ksp)
    add("kspIosArm64", libs.kotlin.inject.anvil.ksp)
    add("kspIosX64", libs.kotlin.inject.anvil.ksp)
    add("kspIosSimulatorArm64", libs.kotlin.inject.anvil.ksp)
    add("kspDesktop", libs.kotlin.inject.anvil.ksp)
    add("kspWasmJs", libs.kotlin.inject.anvil.ksp)
}
