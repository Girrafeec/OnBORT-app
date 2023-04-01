plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltPlugin)
}

android {
    namespace = "com.girrafeecstud.core_network"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "API_BASE_URL", "\"https://girrafeecstud.ru:8080/\"")
        }
        debug {
            buildConfigField("String", "API_BASE_URL", "\"https://girrafeecstud.ru:8080/\"")
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

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitConverterGson)
    implementation(Dependencies.Retrofit.retrofitConverterScalars)

    // OkHttp3
    implementation(Dependencies.OkHttp3.okHttp3)

    // Dagger-Hilt
    implementation(Dependencies.Dagger.Hilt.hilt)
    kapt(Dependencies.Dagger.Hilt.hiltCompiler)
    kapt(Dependencies.Dagger.Hilt.androidxHiltCompiler)

    testImplementation(Dependencies.jUnit.jUnit)

    implementation(project(":core-base"))
}