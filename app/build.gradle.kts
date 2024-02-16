plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.solutionchallenge"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.solutionchallenge"
        minSdk = 28
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

android {
    viewBinding {
        enable = true
    }
    dataBinding {
        enable = true
    }
}


dependencies {


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.firebase:firebase-analytics:21.5.0") //파이어베이스 앱 분석
    implementation("com.google.firebase:firebase-core:21.1.1") //파이어베이스 코어
    implementation("com.google.firebase:firebase-auth:22.3.1") //파이어베이스 인증


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Google Play services
    implementation("com.google.gms:google-services:4.3.15")
    //implementation("com.google.firebase:firebase-auth:22.0.0")
    implementation("com.google.firebase:firebase-bom:32.0.0")
    implementation("com.google.android.gms:play-services-auth:20.5.0")
    //implementation ("com.google.firebase:firebase-admin:8.1.0")


    implementation("androidx.viewpager2:viewpager2:1.0.0")
    val roomVersion = "2.6.1"
    // Room
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    // Room 코루틴
    implementation("androidx.room:room-ktx:$roomVersion")

    val lifecycleVersion = "2.3.0"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // LiveData - 데이터의 변경 사항 파악
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    // 뷰모델 생성하기 쉽게
    implementation("androidx.fragment:fragment-ktx:1.1.0")



    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    //OK HTTP interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.8.0")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:4.9.1")


}