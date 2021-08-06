plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    defaultConfig {
        applicationId = Android.appId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = "com.codingwithmitch.dotainfo.CustomTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies{

    implementation(project(Modules.core))
    implementation(project(Modules.heroDataSource))
    implementation(project(Modules.heroDomain))
    implementation(project(Modules.heroInteractors))

    implementation(project(Modules.ui_heroDetail))
    implementation(project(Modules.ui_heroList))

    implementation(Coil.coil)

    implementation(Accompanist.animations)

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.lifecycleVmKtx)

    implementation(Compose.activity)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.tooling)
    implementation(Compose.navigation)
    implementation(Compose.hiltNavigation)

    implementation(Google.material)

    implementation(Hilt.android)
    kapt(Hilt.compiler)

    implementation(Kotlinx.serialization)
    implementation(Ktor.core)

    implementation(SqlDelight.androidDriver)

    androidTestImplementation(project(Modules.heroDataSourceTest))
    androidTestImplementation(AndroidXTest.runner)
    androidTestImplementation(ComposeTest.uiTestJunit4)
    debugImplementation(ComposeTest.uiTestManifest)
    androidTestImplementation(HiltTest.hiltAndroidTesting)
    kaptAndroidTest(Hilt.compiler)
    androidTestImplementation(Junit.junit4)
}










