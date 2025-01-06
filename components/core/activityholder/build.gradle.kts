plugins {
    id("vas3k.multiplatform")
    id("vas3k.multiplatform-dependencies")
}

androidDependencies {
    implementation(libs.androidx.activity.compose)
}
