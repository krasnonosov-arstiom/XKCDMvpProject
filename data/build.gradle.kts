plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {

    buildTypes.forEach {
        it.buildConfigField("String", "API_URL", "\"https://xkcd.com/\"")
    }
}

dependencies {

    addDaggerDependencies()
    addNetworkDependencies()
    addRoomDependencies()
}