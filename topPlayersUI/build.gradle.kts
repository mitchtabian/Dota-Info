apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.navigation))
    "implementation"(project(Modules.player))
    "implementation"(project(Modules.topPlayerDetailUI))
    "implementation"(project(Modules.topPlayerInteractors))
}