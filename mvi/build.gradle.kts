dependencies {
  implementation(Deps.Kotlin.stdlib)

  implementation(Deps.Rx.java2)
  implementation(Deps.Rx.kotlin)
  implementation(Deps.Rx.relay)
  implementation(Deps.Rx.replayingShare)

  implementation(Deps.Javax.inject)

  testImplementation(Deps.Test.junit)
  testImplementation(Deps.Kotlin.test)
}
