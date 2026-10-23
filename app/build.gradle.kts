plugins {
    id("com.android.application")
}

android {
    namespace = "dev.wua1331.neteaseqqregisterhelper"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.wua1331.neteaseqqregisterhelper"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // Vector supports the legacy Xposed API. Compile-only keeps the framework API
    // out of the APK; the host framework supplies it at runtime.
    compileOnly("de.robv.android.xposed:api:82")
}
