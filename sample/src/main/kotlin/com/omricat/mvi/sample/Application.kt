package com.omricat.mvi.sample

import com.omricat.mvi.sample.feature1.Feature1Component
import com.omricat.mvi.sample.feature2.Feature2Component
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlin.system.exitProcess
import com.omricat.mvi.sample.feature1.Event as Event1
import com.omricat.mvi.sample.feature1.ViewState as ViewState1
import com.omricat.mvi.sample.feature2.Event as Event2
import com.omricat.mvi.sample.feature2.ViewState as ViewState2

fun main(vararg args: String) {

  val appComponent: MviSampleComponent = DaggerMviSampleComponent.create()

  val feature1Component: Feature1Component = appComponent.feature1Component
  val feature1Events: PublishSubject<Event1> = PublishSubject.create()
  val feature1State: Observable<out ViewState1> = feature1Component.binder(feature1Events)

  val feature2Component: Feature2Component = appComponent.feature2Component
  val feature2Events: PublishSubject<Event2> = PublishSubject.create()
  val feature2State: Observable<out ViewState2> = feature2Component.binder(feature2Events)

  feature2State.subscribe {
    when (it) {
      is ViewState2.NoCat -> {
        println("That's a shame, no cats :(")
      }
      is ViewState2.HasCats ->
          println("Cats!!!\n${it.cats.joinToString()}")
    }
  }

  waitForEnter()
  feature2Events.onNext(Event2.CatAdded("Bob"))
  feature2Events.onNext(Event2.CatAdded("Bob"))
  feature2Events.onNext(Event2.CatAdded("Simon"))
  waitForEnter()
  feature2Events.onNext(Event2.CatRemoved("Bob"))
  feature2Events.onNext(Event2.CatAdded("Fury"))

  feature1State.subscribe {
    when (it) {
      is ViewState1.NoGreeting -> {
        println("Initializing...")
      }
      is ViewState1.Greeting -> println("Hello to you ${it.greeting}")
      is ViewState1.Exit -> exitProcess(0)
    }
  }

  waitForEnter()
  feature1Events.onNext(Event1.GreetingRequested)
  waitForEnter()
  feature1Events.onNext(Event1.ExitRequested)

}

fun waitForEnter() =
  System.console()
    ?.run {
      printf("\nPress <Enter>\n")
      readLine()
    }
