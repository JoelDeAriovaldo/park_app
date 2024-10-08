plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.parkapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.parkapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.navigation:navigation-fragment:2.6.0")
    implementation ("androidx.navigation:navigation-ui:2.6.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.zxing:core:3.4.1")
    implementation ("com.google.zxing:javase:3.4.1")
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.8.20")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.20")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.20")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")
}