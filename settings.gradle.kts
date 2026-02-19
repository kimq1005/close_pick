pluginManagement {
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
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "close_pick"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")


//core
include(
    "core:data",
    ":core:domain",
    ":core:router",
    ":core:router:router"
)

//feature
include(
    "feature:main",
    "feature:home",
    "feature:join",
)