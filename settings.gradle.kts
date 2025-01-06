enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Vas3kMobile"
include(
    ":instances:vas3k",

    ":components:core:di",
    ":components:core:activityholder",
    ":components:core:log",
    ":components:core:ktx",
    ":components:core:data",
    ":components:core:build-konfig",
    ":components:core:ui:decompose",
    ":components:core:ui:lifecycle",

    ":components:vas3k:core:theme",

    ":components:vas3k:root:api",
    ":components:vas3k:root:impl",
    ":components:vas3k:preference:api",
    ":components:vas3k:preference:impl",
)
