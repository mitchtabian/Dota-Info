apply {
    from("$rootDir/android-library-build.gradle")
}


dependencies {
    "implementation"(project(Modules.herosBusiness))

    "implementation"(project(Modules.navigation))
}