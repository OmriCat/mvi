@file:Suppress("unused")

object Versions {
  const val gradle = "4.6"
  const val agp = "3.0.1"
  const val kotlin = "1.2.31"
  const val buildTools = "26.0.2"
  const val compileSdk = 27
  const val minSdk = 19
  const val targetSdk = 27

  object Omricat {
    const val kommons = "0.3.2"
  }

  object Support {
    const val library = "27.0.2"
    const val constraintLayout = "1.0.2"
  }

  object Di {
    const val kapsule = "0.3"
    const val dagger = "2.15"
  }

  object Rx {
    const val java2 = "2.1.10"
    const val android = "2.0.1"
    const val kotlin = "2.2.0"
    const val test = "1.0.5"
    const val preferences = "2.0.0-RC3"
    const val relay = "2.0.0"
    const val binding = "2.0.0"
    const val replayingShare = "2.0.1"
  }

  object Net {
    const val okhttp = "3.8.0"
    const val retrofit = "2.3.0"
  }

  object Test {
    const val junit = "4.12"
    const val assertj = "3.7.0"
    const val mockito = "2.7.22"
  }

  object Json {
    const val moshi = "1.5.0"
  }

  object Misc {
    const val timber = "4.6.0"
    const val timberkt = "1.3.0"
    const val okio = "1.13.0"
    const val picasso = "2.5.2"
    const val ktx = "0.2"
  }
  object Javax {
    const val inject = "1"
  }

  object Build {
    object Nebula {
      const val resolutionRules = "5.1.1"
    }
  }
}

object Deps {
  object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val test = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
  }

  object Di {
    const val kapsule =
      "space.traversal.kapsule:kapsule-core:${Versions.Di.kapsule}"

    object Dagger {
      const val runtime = "com.google.dagger:dagger:${Versions.Di.dagger}"
      const val compiler =
        "com.google.dagger:dagger-compiler:${Versions.Di.dagger}"
    }
  }

  object Omricat {
    const val kommons = "com.github.omricat:kommons:${Versions.Omricat.kommons}"
  }

  object Support {
    const val appcompat =
      "com.android.support:appcompat-v7:${Versions.Support.library}"
    const val design = "com.android.support:design:${Versions.Support.library}"
    const val supportv4 =
      "com.android.support:design:${Versions.Support.library}"
    const val recyclerView =
      "com.android.support:recyclerview-v7:${Versions.Support.library}"
    const val cardView =
      "com.android.support:cardview-v7:${Versions.Support.library}"
    const val constraintLayout =
      "com.android.support.constraint:constraint-layout:${Versions.Support.constraintLayout}"
  }

  object Rx {
    const val java2 = "io.reactivex.rxjava2:rxjava:${Versions.Rx.java2}"
    const val android = "io.reactivex.rxjava2:rxandroid:${Versions.Rx.android}"
    const val kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.Rx.kotlin}"
    const val test = "com.rubylichtenstein:rxtest:${Versions.Rx.test}"
    const val preferences =
      "com.f2prateek.rx.preferences2:rx-preferences:${Versions.Rx.preferences}"
    const val relay = "com.jakewharton.rxrelay2:rxrelay:${Versions.Rx.relay}"
    const val replayingShare =
      "com.jakewharton.rx2:replaying-share-kotlin:${Versions.Rx.replayingShare}"

    object Binding {
      const val core =
        "com.jakewharton.rxbinding2:rxbinding:${Versions.Rx.binding}"
      const val support =
        "com.jakewharton.rxbinding2:rxbinding-support-v4:${Versions.Rx.binding}"
      const val appcompat =
        "com.jakewharton.rxbinding2:rxbinding-appcompat-v7:${Versions.Rx.binding}"
      const val design =
        "com.jakewharton.rxbinding2:rxbinding-design:${Versions.Rx.binding}"
      const val recyclerview =
        "com.jakewharton.rxbinding2:rxbinding-recyclerview-v7:${Versions.Rx.binding}"

      object Kotlin {
        const val core =
          "com.jakewharton.rxbinding2:rxbinding-kotlin:${Versions.Rx.binding}"
        const val support =
          "com.jakewharton.rxbinding2:rxbinding-support-v4-kotlin:${Versions.Rx.binding}"
        const val appcompat =
          "com.jakewharton.rxbinding2:rxbinding-appcompat-v7-kotlin:${Versions.Rx.binding}"
        const val design =
          "com.jakewharton.rxbinding2:rxbinding-design-kotlin:${Versions.Rx.binding}"
        const val recyclerview =
          "com.jakewharton.rxbinding2:rxbinding-recyclerview-v7-kotlin:${Versions.Rx.binding}"
      }
    }
  }

  object Net {
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Net.okhttp}"

    object Retrofit {

      const val core =
        "com.squareup.retrofit2:retrofit:${Versions.Net.retrofit}"

      object Adapters {
        const val rxJava2 =
          "com.squareup.retrofit2:adapter-rxjava2:${Versions.Net.retrofit}"
      }

      object Converters {
        const val moshi =
          "com.squareup.retrofit2:converter-moshi:${Versions.Net.retrofit}"
      }
    }
  }

  object Json {
    const val moshi = "com.squareup.moshi:moshi:${Versions.Json.moshi}"
    const val moshiKotlin =
      "com.squareup.moshi:moshi-kotlin:${Versions.Json.moshi}"
  }

  object Misc {
    const val okio = "com.squareup.okio:okio:${Versions.Misc.okio}"
    const val timber = "com.jakewharton.timber:timber:${Versions.Misc.timber}"
    const val timberkt = "com.github.ajalt:timberkt:${Versions.Misc.timberkt}"
    const val picasso =
      "com.squareup.picasso:picasso:${Versions.Misc.picasso}"
    const val ktx = "androidx.core:core-ktx:${Versions.Misc.ktx}"
  }

  object Test {
    const val junit = "junit:junit:${Versions.Test.junit}"
    const val assertj = "org.assertj:assertj-core:${Versions.Test.assertj}"
    const val mockito = "org.mockito:mockito-core:${Versions.Test.mockito}"
  }

  object Javax {
    const val inject = "javax.inject:javax.inject:${Versions.Javax.inject}"
  }

  object Build {
    object Nebula {
      const val resolutionRules = "nebula.resolution-rules"
    }
  }
}
