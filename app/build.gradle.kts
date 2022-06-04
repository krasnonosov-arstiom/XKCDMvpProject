plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.androidMaterial)
    implementation(Libraries.constraintLayout)
}