apply {
    from("$rootDir/library-build.gradle")
}


dependencies {
    "implementation"(project(Modules.core))
}