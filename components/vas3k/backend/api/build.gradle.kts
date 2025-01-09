plugins {
    id("vas3k.multiplatform")
    id("vas3k.multiplatform-dependencies")
    alias(libs.plugins.kotlin.serialization)
}

commonDependencies {
    implementation(libs.kotlin.serialization.json)
    implementation(libs.kotlin.datetime)
}
