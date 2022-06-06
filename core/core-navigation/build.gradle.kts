plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

dependencies {

    implementation(project(":core:core-feature"))

    implementation(project(":features:feature-search"))
    implementation(project(":features:feature-favourite"))

    addNavigationComponentDependencies()
    addDaggerDependencies()
}