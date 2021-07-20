apply {
    from("$rootDir/android-ui-build.gradle")
}


dependencies {
    "implementation"(project(Modules.heroDomain))
    "implementation"(project(Modules.heroInteractors))

    "implementation"(SqlDelight.androidDriver)
}