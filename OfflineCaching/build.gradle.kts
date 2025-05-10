// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.android.application) apply false  // For :app module (Android app)
    alias(libs.plugins.kotlin.android) apply false       // For Kotlin Android support
    alias(libs.plugins.kotlin.compose) apply false       // For Jetpack Compose plugin
    alias(libs.plugins.kotlin.kapt) apply false          // For Kotlin annotation processing (Room, etc.)
}
