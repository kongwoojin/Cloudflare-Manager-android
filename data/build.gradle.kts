plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jlleitschuh.gradle.ktlint") version Version.ktlint
}

android {
    namespace = "com.kongjak.cloudflaremanager.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
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
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(Dependency.AndroidX.coreKtx)
    implementation(Dependency.AndroidX.datastorePreference)
    implementation(Dependency.Hilt.hilt)
    kapt(Dependency.Hilt.hiltCompiler)
    implementation(Dependency.Okhttp.retrofit)
    implementation(Dependency.Okhttp.convertGson)
    implementation(Dependency.Okhttp.okhttp)
    implementation(Dependency.Okhttp.loggingInterceptor)
    testImplementation(Dependency.Test.junit)
    androidTestImplementation(Dependency.AndroidTest.junit)
    androidTestImplementation(Dependency.AndroidTest.espresso)
}
