apply {
    from("$rootDir/library-build.gradle")
}


dependencies {
    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)
}