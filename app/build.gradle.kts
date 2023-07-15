plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint") version Version.ktlint
}

android {
    namespace = "com.kongjak.cloudflaremanager"
    compileSdk = Project.compileSdk

    defaultConfig {
        applicationId = "com.kongjak.cloudflaremanager"
        minSdk = Project.minSdk
        targetSdk = Project.targetSdk
        versionCode = Project.versionCode
        versionName = Project.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        jvmTarget = Version.Java.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.Kotlin.kotlinCompilerExtension
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(Dependency.AndroidX.coreKtx)
    implementation(project.dependencies.platform(Dependency.Kotlin.kotlinBom))
    implementation(Dependency.AndroidX.lifecycleRuntime)
    implementation(Dependency.AndroidX.activityCompose)
    implementation(project.dependencies.platform(Dependency.AndroidX.composeBom))
    implementation(Dependency.AndroidX.composeUI)
    implementation(Dependency.AndroidX.composeUIGraphics)
    implementation(Dependency.AndroidX.composeUIToolingPreview)
    implementation(Dependency.AndroidX.composeMaterial3)
    testImplementation(Dependency.Test.junit)
    androidTestImplementation(Dependency.AndroidTest.junit)
    androidTestImplementation(Dependency.AndroidTest.espresso)
    androidTestImplementation(project.dependencies.platform(Dependency.AndroidTest.composeBom))
    androidTestImplementation(Dependency.AndroidTest.composeJunit)
    debugImplementation(Dependency.Debug.composeUITooling)
    debugImplementation(Dependency.Debug.composeUITestManifest)
}
