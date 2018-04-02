import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }
  dependencies {
    classpath(Deps.Kotlin.gradlePlugin)
  }
}

plugins {
  kotlin("jvm") version Versions.kotlin
  id(Deps.Build.Nebula.resolutionRules) version Versions.Build.Nebula.resolutionRules
}
apply {
  plugin("kotlin")
}

allprojects {

  buildscript {
    repositories {
      mavenCentral()
      jcenter()
    }
    dependencies {
      classpath(Deps.Kotlin.gradlePlugin)
    }
  }

  group = "com.omricat"
  version = "0.0.1"

  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.6"
  }

  repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
  }

  apply {
    plugin("kotlin")
    plugin(Deps.Build.Nebula.resolutionRules)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  resolutionRules("com.netflix.nebula:gradle-resolution-rules:0.52.0")
}
