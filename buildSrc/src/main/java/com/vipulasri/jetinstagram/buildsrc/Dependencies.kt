package com.vipulasri.jetinstagram.buildsrc

object Libs {
  const val androidGradlePlugin = "com.android.tools.build:gradle:8.5.2"
  const val junit = "junit:junit:4.13"

  const val exoplayer = "com.google.android.exoplayer:exoplayer:2.15.0"

  object Coil {
    private const val version = "1.3.2"
    const val sdk = "io.coil-kt:coil-compose:$version"
  }

  object Kotlin {
    private const val version = "1.9.0"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
  }

  object Coroutines {
    private const val version = "1.6.0"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
  }

  object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:1.6.0" // Updated version
    const val coreKtx = "androidx.core:core-ktx:1.10.0" // Updated version
    const val material = "com.google.android.material:material:1.9.0" // Updated version
    const val tooling = "androidx.ui:ui-tooling:1.0.0-alpha07"

    object Compose {
      const val version = "1.5.0" // Updated Compose version for compatibility with Kotlin 1.9.0
      const val activityComposeVersion = "1.7.0" // Updated version

      const val runtime = "androidx.compose.runtime:runtime:$version"
      const val compiler = "androidx.compose.compiler:compiler:$version"
      const val foundation = "androidx.compose.foundation:foundation:$version"
      const val layout = "androidx.compose.foundation:foundation-layout:$version"
      const val ui = "androidx.compose.ui:ui:$version"
      const val tooling = "androidx.compose.ui:ui-tooling:$version"
      const val material = "androidx.compose.material:material:$version"
      const val animation = "androidx.compose.animation:animation:$version"
      const val activity = "androidx.activity:activity-compose:$activityComposeVersion"
    }

    object Test {
      private const val version = "1.5.0" // Updated version
      const val core = "androidx.test:core:$version"
      const val rules = "androidx.test:rules:$version"

      object Ext {
        private const val version = "1.1.5" // Updated version
        const val junit = "androidx.test.ext:junit-ktx:$version"
      }

      const val espressoCore = "androidx.test.espresso:espresso-core:3.5.0" // Updated version
    }
  }
}
