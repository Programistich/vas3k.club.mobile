plugins {
<#if isScreenComponent || isCompositeComponent>
    id("vas3k.multiplatform-compose")
    id("vas3k.anvil-multiplatform")
<#else>
    id("vas3k.multiplatform")
</#if>
<#if isCompositeComponent>
    alias(libs.plugins.kotlin.serialization)
</#if>
    id("vas3k.multiplatform-dependencies")
}

commonDependencies {
    implementation(projects.components.vas3k.${__moduleName}.api)

<#if isScreenComponent || isCompositeComponent>
    implementation(projects.components.core.di)
    implementation(projects.components.core.ui.decompose)

    implementation(libs.decompose)
</#if>
}