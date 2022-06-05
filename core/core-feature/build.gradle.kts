plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

dependencies {

    implementation(project(":domain"))

    addCommonDependencies()
    addDaggerDependencies()
    addCoroutinesDependencies()
    implementation(Libraries.liveEvents)
}