
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.hiltAndroid)
        classpath(Build.sqlDelightGradlePlugin)
        classpath(Build.byeByeJetifier)
    }
}

apply(plugin = "com.dipien.byebyejetifier")

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}