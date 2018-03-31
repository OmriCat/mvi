plugins {
  application
  java
  id("kotlin-kapt")
}

application {
  mainClassName = "com.omricat.mvi.sample.ApplicationKt"
}

dependencies {
  implementation(project(":mvi"))
  implementation(project(":mvi-dagger"))
  implementation(Deps.Kotlin.stdlib)

  implementation(Deps.Rx.java2)
  implementation(Deps.Rx.kotlin)

  implementation(Deps.Di.Dagger.runtime)
  "kapt"(Deps.Di.Dagger.compiler)

  testImplementation(Deps.Test.junit)
  testImplementation(Deps.Kotlin.test)
}
