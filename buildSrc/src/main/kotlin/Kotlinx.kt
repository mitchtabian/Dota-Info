object Kotlinx {
    private const val kotlinxDatetimeVersion = "0.1.1"
    const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion"

    private const val coroutinesCoreVersion = "1.5.1"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesCoreVersion"

    // Need for tests. Plugin doesn't work.
    private const val serializationVersion = "1.2.2"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"
}