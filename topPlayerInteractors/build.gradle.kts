apply {
    from("$rootDir/library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.constants))
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.player))
    "implementation"(project(Modules.topPlayerService))

    "implementation"(Kotlinx.coroutinesCore)

    "testImplementation"(Junit.junit4)
    "testImplementation"(Ktor.ktorClientMock)
}

