plugins {
    id("vas3k.multiplatform-compose")
    id("vas3k.anvil-multiplatform")
    alias(libs.plugins.kotlin.serialization)
    id("vas3k.multiplatform-dependencies")
}

commonDependencies {
    implementation(projects.components.vas3k.root.api)

    implementation(projects.components.core.di)
    implementation(projects.components.core.ui.decompose)

    implementation(libs.decompose)
}