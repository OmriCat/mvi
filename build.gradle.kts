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

repositories {
  mavenCentral()
}

dependencies {
  resolutionRules("com.netflix.nebula:gradle-resolution-rules:0.52.0")
}

subprojects {

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
    plugin("maven-publish")
    plugin(Deps.Build.Nebula.resolutionRules)
  }

  tasks {
    val sourcesJar by creating(Jar::class) {
      dependsOn(JavaPlugin.CLASSES_TASK_NAME)
      classifier = "sources"
      from(java.sourceSets["main"].allSource)
    }

    val javadocJar by tasks.creating(Jar::class) {
      dependsOn(JavaPlugin.JAVADOC_TASK_NAME)
      classifier = "javadoc"
      from(java.docsDir)
    }

    artifacts {
      add("archives", sourcesJar)
      add("archives", javadocJar)
    }
  }
}
