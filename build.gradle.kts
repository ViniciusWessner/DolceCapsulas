// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        val nav_version = "2.8.0"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath("com.google.gms:google-services:4.4.2")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    //firebase
    id("com.google.gms.google-services") version "4.4.2" apply false

    //dagger hilt (nao reduzir versao)
    id("com.google.dagger.hilt.android") version "2.48" apply false
}