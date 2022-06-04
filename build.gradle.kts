// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    plugins.withType<com.android.build.gradle.internal.plugins.BasePlugin<*, *, *, *>> {
        configure<com.android.build.gradle.BaseExtension> {
            compileSdkVersion(AndroidSdk.compile)
            defaultConfig {
                minSdk = AndroidSdk.min
                targetSdk = AndroidSdk.target

                versionCode = 1
                versionName = "1.0"

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            if (displayName.contains("feature")) buildFeatures.viewBinding = true
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}