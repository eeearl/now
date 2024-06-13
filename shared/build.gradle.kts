import org.apache.tools.ant.taskdefs.condition.Os

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.jetbrains.compose)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "19"
            }
        }
    }

//    if (!Os.isFamily(Os.FAMILY_WINDOWS)) {
//        listOf(
//            iosX64(),
//            iosArm64(),
//            iosSimulatorArm64()
//        ).forEach {
//            it.binaries.framework {
//                baseName = "shared"
//                isStatic = true
//            }
//        }
//    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.androidx.runtime)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.client.logging)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.core)
            implementation(libs.koin.test)

            api(libs.androidx.lifecycle.viewmodel)

            /*
            implementation(libs.coil)
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
             */
            implementation(libs.kamel.image)

            // Jetbrains Compose
            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)

            implementation(libs.napier)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            implementation(libs.kotlinx.coroutines.android)
            /*
            implementation(libs.coil.okhttp)
             */
        }
        if (!Os.isFamily(Os.FAMILY_WINDOWS)) {
//            iosMain.dependencies {
//                implementation(libs.ktor.client.darwin)
//            }
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.eeearl.now"
    compileSdk = 34
    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}
