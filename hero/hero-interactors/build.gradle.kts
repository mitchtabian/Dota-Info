apply {
    from("$rootDir/library-build.gradle")
}


dependencies {
    "implementation"(project(Modules.heroDataSource))
    "implementation"(project(Modules.heroDomain))
}