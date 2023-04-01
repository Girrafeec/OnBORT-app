plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltPlugin)
    id(Plugins.safeArgs)
    id(Plugins.kotlinParcelize)
}

android {
    namespace = "com.girrafeecstud.onbort"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.girrafeecstud.onbort"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompilerVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // AppCompat
    implementation(Dependencies.AndroidX.AppCompat.appCompat)

    // Core
    implementation(Dependencies.AndroidX.Core.coreKtx)

    // Compose
    implementation(platform(Dependencies.Jetpack.Compose.composeBom))
    implementation(Dependencies.Jetpack.Compose.composeUi)
    implementation(Dependencies.Jetpack.Compose.activityCompose)
    implementation(Dependencies.Jetpack.Compose.composeMaterial)
    implementation(Dependencies.Jetpack.Compose.composeUiTooling)
    implementation(Dependencies.Jetpack.Compose.composeUiToolingPreview)

    // Unit-tests
    testImplementation(Dependencies.jUnit.jUnit)
    testImplementation(Dependencies.OkHttp3.mockWebServer)
    testImplementation(Dependencies.Coroutines.coroutinesTest)
    testImplementation(Dependencies.Mockito.mockitoKotlin)
    testImplementation(Dependencies.Mockito.mockitoInline)
    testImplementation(Dependencies.SharedPreferences.shafranSharedPreferencesMock)

    // ConstraintLayout
    implementation(Dependencies.AndroidX.Constraintlayout.constraintLayout)

    // Google Material
    implementation(Dependencies.Google.Material.material)

    // Dagger-Hilt
    implementation(Dependencies.Dagger.Hilt.hilt)
    kapt(Dependencies.Dagger.Hilt.hiltCompiler)
    kapt(Dependencies.Dagger.Hilt.androidxHiltCompiler)
    implementation(Dependencies.Jetpack.Compose.hiltNavigationCompose)

    // Navigation
    implementation(Dependencies.Jetpack.Navigation.navigationFragmentKtx)
    implementation(Dependencies.Jetpack.Navigation.navigationUiKtx)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitConverterGson)
    implementation(Dependencies.Retrofit.retrofitConverterScalars)

    // OkHttp3
    implementation(Dependencies.OkHttp3.okHttp3)

    // Room
    implementation(Dependencies.Jetpack.Room.room)
    kapt(Dependencies.Jetpack.Room.roomCompiler)
    implementation(Dependencies.Jetpack.Room.roomKtx)

    // ViewModel, LiveData
    implementation(Dependencies.Jetpack.ViewModel.viewModel)
    implementation(Dependencies.Jetpack.LiveData.liveData)
    implementation(Dependencies.Jetpack.Compose.viewModelCompose)

    // Coroutines
    implementation(Dependencies.Coroutines.coroutines)

    // Picasso
    implementation(Dependencies.Picasso.picasso)

    // Glide
    implementation(Dependencies.Glide.glide)
    kapt(Dependencies.Glide.glideCompiler)

    // Firebase
    implementation(platform(Dependencies.Firebase.firebaseBom))
    implementation(Dependencies.Firebase.firebaseMessaging)
    implementation(Dependencies.Firebase.firebaseAnalytics)

    implementation(project(":core-base"))
    implementation(project(":core-ui"))
    implementation(project(":core-network"))
    implementation(project(":core-db"))
}