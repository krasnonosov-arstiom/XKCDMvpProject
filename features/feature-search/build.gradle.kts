plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

dependencies {

    implementation(project(":core:core-feature"))
    implementation(project(":domain"))

    addFeatureDependencies()
}