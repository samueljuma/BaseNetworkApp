plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.samueljuma.lib3"
    compileSdk {
        version = release(36)
    }
}
