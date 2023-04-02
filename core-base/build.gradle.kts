plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltPlugin)
//    id(Plugins.safeArgs)
    id(Plugins.kotlinParcelize)
}

android {
    namespace = "com.girrafeecstud.core_base"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // OkHttp3
    implementation(Dependencies.OkHttp3.okHttp3)
    implementation(Dependencies.OkHttp3.mockWebServer)

    // Unit-tests
    testImplementation(Dependencies.jUnit.jUnit)
    testImplementation(Dependencies.OkHttp3.mockWebServer)
    testImplementation(Dependencies.Coroutines.coroutinesTest)
    testImplementation(Dependencies.Mockito.mockitoKotlin)
    testImplementation(Dependencies.Mockito.mockitoInline)

    // Dagger-Hilt
    implementation(Dependencies.Dagger.Hilt.hilt)
    kapt(Dependencies.Dagger.Hilt.hiltCompiler)
    kapt(Dependencies.Dagger.Hilt.androidxHiltCompiler)
    implementation(Dependencies.Jetpack.Compose.hiltNavigationCompose)

    // Navigation
    implementation(Dependencies.Jetpack.Navigation.navigationFragmentKtx)
    implementation(Dependencies.Jetpack.Navigation.navigationUiKtx)

    // ViewModel
    implementation(Dependencies.Jetpack.ViewModel.viewModel)
    implementation(Dependencies.Jetpack.LiveData.liveData)
    implementation(Dependencies.Jetpack.Compose.viewModelCompose)

    // Coroutines
    implementation(Dependencies.Coroutines.coroutines)
}