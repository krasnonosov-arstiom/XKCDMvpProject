import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {

    const val coreKtx = "1.8.0"
    const val appCompat = "1.4.2"
    const val androidMaterial = "1.6.1"
    const val constraintLayout = "2.1.4"

    const val buildGradle = "7.2.1"
    const val kotlinGradlePlugin = "1.6.10"

    const val dagger = "2.37"

    const val retrofit = "2.9.0"
    const val okHttp = "4.9.1"

    const val coroutines = "1.5.2"

    const val glide = "4.13.0"

    const val navigation = "2.4.2"

    const val room = "2.4.2"

    const val liveEvents = "1.3.0"

    const val lifecycleViewModel = "2.4.1"
}

object AndroidSdk {

    const val min = 24
    const val compile = 32
    const val target = compile
}

object BuildPlugins {

    const val buildGradle = "com.android.tools.build:gradle:${Versions.buildGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"
}

object Libraries {

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val kaptDaggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val navigationFragments = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val liveEvents = "com.github.hadilq:live-event:${Versions.liveEvents}"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"
}

fun DependencyHandler.addCommonDependencies() {
    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.androidMaterial)
}

/**
 * Do not forget add kotlin("kapt") plugin into build.gradle.kts module
 */
fun DependencyHandler.addDaggerDependencies() {
    implementation(Libraries.dagger)
    kapt(Libraries.kaptDaggerCompiler)
}

fun DependencyHandler.addNetworkDependencies() {
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGsonConverter)
    implementation(Libraries.okHttp)
    implementation(Libraries.okHttpLoggingInterceptor)
}

fun DependencyHandler.addCoroutinesDependencies() {
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)
}

/**
 * Do not forget add kotlin("kapt") plugin into build.gradle.kts module
 */
fun DependencyHandler.addGlideDependencies() {
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)
}

/**
 * Do not forget add kotlin("kapt") plugin into build.gradle.kts module
 */
fun DependencyHandler.addRoomDependencies() {
    implementation(Libraries.roomRuntime)
    kapt(Libraries.roomCompiler)
    implementation(Libraries.roomKtx)
}

fun DependencyHandler.addNavigationComponentDependencies() {
    implementation(Libraries.navigationFragments)
    implementation(Libraries.navigationUiKtx)
}

fun DependencyHandler.addFeatureDependencies() {
    addCommonDependencies()
    addDaggerDependencies()
    addCoroutinesDependencies()
    addGlideDependencies()
}

private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)