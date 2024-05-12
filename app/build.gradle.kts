plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
<<<<<<< HEAD
    id("kotlin-android")
    kotlin("kapt")
=======
>>>>>>> d2c8ba4714721cca58f5b626cb7a08df17986eb8
}

android {
    namespace = "com.example.todoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.todoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
<<<<<<< HEAD
    buildFeatures {
        viewBinding = true
    }
=======
>>>>>>> d2c8ba4714721cca58f5b626cb7a08df17986eb8
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.room:room-runtime:2.4.0")
    kapt("androidx.room:room-compiler:2.4.0")
}

