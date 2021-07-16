apply {
    from("$rootDir/android-library-build.gradle")
}


dependencies {
    "implementation"(project(Modules.navigation))
    "implementation"(project(Modules.playersBusiness))
}