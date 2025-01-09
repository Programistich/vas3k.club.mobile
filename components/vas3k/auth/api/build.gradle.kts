plugins {
    id("vas3k.multiplatform")
    id("vas3k.multiplatform-dependencies")
    id("kotlinx-serialization")
}

commonDependencies {
    implementation(libs.decompose)
    implementation(projects.components.core.ui.decompose)
}
