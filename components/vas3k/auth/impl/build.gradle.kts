plugins {
    id("vas3k.multiplatform-compose")
    id("vas3k.multiplatform-dependencies")
    id("vas3k.anvil-multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

commonDependencies {
    implementation(projects.components.vas3k.auth.api)
    implementation(projects.components.vas3k.backend.api)

    implementation(projects.components.core.di)
    implementation(projects.components.core.ktx)
    implementation(projects.components.core.log)
    implementation(projects.components.core.ui.decompose)
    implementation(projects.components.core.ui.lifecycle)
}