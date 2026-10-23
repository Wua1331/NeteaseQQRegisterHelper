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
        versionCode = 3
        versionName = "0.3.0"
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
    // Vector v2.2 is designed around modern libxposed APIs.
    // Keep the framework API compile-only; it is provided by Vector at runtime.
    compileOnly("io.github.libxposed:api:102.0.0")
}
