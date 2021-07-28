plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.codingwithmitch.dotainfo"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0"
    }
}

dependencies{
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")

    implementation("androidx.activity:activity-compose:1.3.0")

    implementation("androidx.compose.foundation:foundation:1.0.0")
    implementation("androidx.compose.foundation:foundation-layout:1.0.0")
    implementation("androidx.compose.material:material:1.0.0")
    implementation("androidx.compose.runtime:runtime:1.0.0")
    implementation("androidx.compose.ui:ui-tooling:1.0.0")

}










