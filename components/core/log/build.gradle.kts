plugins {
    id("vas3k.multiplatform")
    id("vas3k.multiplatform-dependencies")
}

commonDependencies {
    implementation(projects.components.core.buildKonfig)
}

androidDependencies {
    implementation(libs.timber)
}
