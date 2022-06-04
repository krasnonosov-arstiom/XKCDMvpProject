
object AndroidSdk {

    const val min = 24
    const val compile = 32
    const val target = compile
}

object Versions {

    const val coreKtx = "1.8.0"
    const val appCompat = "1.4.2"
    const val androidMaterial = "1.6.1"
    const val constraintLayout = "2.1.4"
}

object Libraries {

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}