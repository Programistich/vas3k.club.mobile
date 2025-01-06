plugins {
    id("vas3k.anvil-multiplatform")
    id("vas3k.multiplatform-compose")
    id("vas3k.multiplatform-dependencies")
    alias(libs.plugins.kotlin.serialization)
}

commonDependencies {
    implementation(projects.components.vas3k.preference.api)

    implementation(projects.components.core.di)
    implementation(projects.components.core.ktx)
    implementation(projects.components.vas3k.core.theme)
    implementation(projects.components.core.ui.lifecycle)
    implementation(projects.components.core.ui.decompose)

    implementation(libs.decompose)

    implementation(libs.kotlin.serialization.json)
    implementation(libs.settings)
    implementation(libs.settings.coroutines)
}
