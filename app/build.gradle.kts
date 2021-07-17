plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
}

dependencies{

    implementation(project(Modules.core))

    implementation(project(Modules.hero))

    implementation(project(Modules.herosUI))

    implementation(project(Modules.heroDetailUI))

    implementation(project(Modules.heroService))

    implementation(project(Modules.heroCache))

    implementation(project(Modules.heroInteractors))

    implementation(project(Modules.navigation))

    implementation(project(Modules.player))

    implementation(project(Modules.topPlayersUI))

    implementation(project(Modules.topPlayerDetailUI))

    implementation(project(Modules.topPlayerService))

    implementation(project(Modules.topPlayerCache))

    implementation(project(Modules.topPlayerInteractors))

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

    implementation(Ktor.core)
}










