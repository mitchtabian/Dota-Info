apply {
    from("$rootDir/android-library-build.gradle")
}


plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(SqlDelight.plugin)
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.heroDomain))

    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)

    "implementation"(SqlDelight.runtime)
    "implementation"(SqlDelight.androidDriver)
}

sqldelight {
    database("HeroDatabase") {
        packageName = "com.codingwithmitch.dotainfo.hero_datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}