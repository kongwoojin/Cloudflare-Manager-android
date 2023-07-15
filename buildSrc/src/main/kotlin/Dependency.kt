object Dependency {
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Version.AndroidX.coreKtx}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.AndroidX.lifecycleRuntime}"
        const val activityCompose = "androidx.activity:activity-compose:${Version.AndroidX.activityCompose}"
        const val composeUI = "androidx.compose.ui:ui:${Version.AndroidX.composeUI}"
        const val composeUIGraphics = "androidx.compose.ui:ui-graphics:${Version.AndroidX.composeUIGraphics}"
        const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.AndroidX.composeUIToolingPreview}"
        const val composeMaterial3 = "androidx.compose.material3:material3:${Version.AndroidX.composeMaterial3}"
        const val composeBom = "androidx.compose:compose-bom:${Version.AndroidX.composeBom}"
        const val datastorePreference = "androidx.datastore:datastore-preferences:${Version.AndroidX.datastorePreference}"
    }

    object Kotlin {
        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:${Version.Kotlin.kotlinBom}"
    }

    object Test {
        const val junit = "junit:junit:${Version.Test.junit}"
    }

    object AndroidTest {
        const val junit = "androidx.test.ext:junit:${Version.AndroidTest.junit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.AndroidTest.espresso}"
        const val composeBom = "androidx.compose:compose-bom:${Version.AndroidTest.composeBom}"
        const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Version.AndroidTest.composeJunit}"
    }

    object Debug {
        const val composeUITooling = "androidx.compose.ui:ui-tooling:${Version.Debug.composeUITooling}"
        const val composeUITestManifest = "androidx.compose.ui:ui-test-manifest:${Version.Debug.composeUITestManifest}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Version.Hilt.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.Hilt.hilt}"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
}