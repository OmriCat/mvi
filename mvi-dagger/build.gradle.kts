plugins {
  kotlin("kapt")
  java
}

dependencies {
  implementation(project(":mvi"))
  implementation(Deps.Kotlin.stdlib)

  implementation(Deps.Rx.java2)
  implementation(Deps.Rx.kotlin)
  implementation(Deps.Rx.relay)
  implementation(Deps.Rx.replayingShare)

  implementation(Deps.Javax.inject)

  implementation(Deps.Di.Dagger.runtime)
  "kapt"(Deps.Di.Dagger.compiler)

  testImplementation(Deps.Test.junit)
  testImplementation(Deps.Kotlin.test)
}
