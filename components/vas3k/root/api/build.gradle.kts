plugins {
    id("vas3k.multiplatform-compose")
    id("vas3k.multiplatform-dependencies")
    alias(libs.plugins.kotlin.serialization)
}

commonDependencies {
    implementation(libs.decompose)
    implementation(projects.components.core.ui.decompose)
}