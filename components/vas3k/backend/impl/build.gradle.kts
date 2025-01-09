plugins {
    id("vas3k.multiplatform")
    id("vas3k.multiplatform-dependencies")
    alias(libs.plugins.kotlin.serialization)
    id("vas3k.anvil-multiplatform")
}

commonDependencies {
    implementation(projects.components.vas3k.backend.api)

    implementation(projects.components.vas3k.preference.api)

    implementation(projects.components.core.di)
    implementation(projects.components.core.log)
    implementation(projects.components.core.ktx)

    implementation(libs.kotlin.datetime)
    implementation(libs.kotlin.serialization.json)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.auth)
}

androidDependencies {
    implementation(libs.ktor.client.cio)
}

desktopDependencies {
    implementation(libs.ktor.client.cio)
}

iosDependencies {
    implementation(libs.ktor.client.cio)
}

wasmJsDependencies {
    implementation(libs.ktor.client.js)
}