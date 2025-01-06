plugins {
<#if isScreenComponent || isCompositeComponent>
    id("vas3k.multiplatform-compose")
<#else>
    id("vas3k.multiplatform")
</#if>
    id("vas3k.multiplatform-dependencies")
}

commonDependencies {
<#if isScreenComponent || isCompositeComponent>
    implementation(libs.decompose)
    implementation(projects.components.core.ui.decompose)
</#if>
}