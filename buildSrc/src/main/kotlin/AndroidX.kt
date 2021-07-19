object AndroidX {
    private const val coreKtxVersion = "1.6.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.3.0"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val lifecycleRuntimeVersion = "2.3.1"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeVersion"

    private const val lifecycleVmKtxVersion = "2.4.0-alpha02"
    const val lifecycleVmKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVmKtxVersion"
}

object AndroidXTest {
    private const val version = "1.3.0"
    const val runner = "androidx.test:runner:$version"
    const val rules = "androidx.test:rules:$version"
    const val junitExt = "androidx.test.ext:junit-ktx:1.1.2"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
}