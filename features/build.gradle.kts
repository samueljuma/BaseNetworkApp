plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.samueljuma.features"
    compileSdk {
        version = release(36)
    }
}
