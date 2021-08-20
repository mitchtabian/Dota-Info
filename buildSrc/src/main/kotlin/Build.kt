object Build {
    private const val androidBuildToolsVersion = "7.1.0-alpha03"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.hiltVersion}"

    const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:${SqlDelight.version}"

    private const val byeByeJetifierVersion = "1.1.3"
    const val byeByeJetifier = "com.dipien:bye-bye-jetifier:$byeByeJetifierVersion"
}