plugins{
    id("java-gradle-plugin")
    alias(libs.plugins.kotlin.jvm)
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    implementation(gradleKotlinDsl())

}
gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "libtest.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}