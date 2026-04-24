
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            extensions.configure<LibraryExtensions> {
                compileSdk = 36
                defaultConfig {
                    minSdk = 27
                    testInstrumentationRUnner = "androidx.test.runner.AndroidJUnitRunne"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11

        }
    }

    val libs = extensions.getByType<VersionCatalogExtension>().named("libs")

    dependencies {
        add("implementation", libs.findLibrary("androidx-core-ktx").get())
        add("implementation", libs.findLibrary("androidx-appcompat").get())
        add("implementation", libs.findLibrary("material").get())
        add("testImplementation", libs.findLibrary("junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx-junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx-espresso-core").get())
    }
}