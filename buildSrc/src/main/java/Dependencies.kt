object Modules {
    const val data = ":data"
    const val domain = ":domain"
    const val usecase = ":usecase"
}

object Versions {
    const val compileSdk = 31
    const val appId = "com.secodebase.app"
    const val minSdk = 23
    const val targetSdk = 31

    const val versionCode = 1
    const val versionName = "1.0"

    //kotlin libs
    const val kotlin = "1.6.0"
    const val coroutine = "1.3.9"

    //android libs
    const val androidxCore = "1.7.0"
    const val androidxAppCompat = "1.4.0"
    const val androidxConstraintLayout = "2.1.2"
    const val androidxSwipeRefreshLayout = "1.1.0"
    const val androidxLifecycle = "2.4.0"
    const val androidxNavigationFragmentKtx = "2.3.5"
    const val androidxSupportLegacy = "1.0.0"
    const val androidxBrowser = "1.4.0"
    const val materialDesign = "1.4.0"

    //testing
    const val androidxJunit = "1.1.3"
    const val androidxEspresso = "3.4.0"

    //libs
    const val timber = "4.7.1"
    const val gson = "2.8.7"
    const val retrofit = "2.9.0"
    const val okHttp = "4.9.1"
    const val koin = "3.1.3"
    const val glide = "4.12.0"
    const val coil = "1.4.0"
}

object Libs {

    //Timber log
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //network
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    //koin DI
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"

    //glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"

}

object TestingLibs {
    const val junit = "junit:junit:4.+"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val androidEspersso = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"
}

object KotlinLibs {
    //kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //coroutine
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
}

object AndroidLibs {
    // ANDROID
    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
    const val swipeRefreshLayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.androidxSwipeRefreshLayout}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"
    const val lifecycleCommon =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycle}"
    const val livecycleLiveDataReactiveStream =
        "androidx.lifecycle:lifecycle-reactivestreams:${Versions.androidxLifecycle}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigationFragmentKtx}"
    const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigationFragmentKtx}"
    const val supportLegacy = "androidx.legacy:legacy-support-v4:${Versions.androidxSupportLegacy}"
    const val browser = "androidx.browser:browser:${Versions.androidxBrowser}"

    //material design ui
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
}