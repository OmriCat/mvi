package com.omricat.mvi.sample

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlin.system.exitProcess

fun main(vararg args: String) {

  val component = component()

  val events: PublishSubject<Event> = PublishSubject.create()

  val state: Observable<out ViewState> = component.binder(events)

  state.subscribe {
    when (it) {
      is ViewState.NoGreeting -> {
        println("Initializing...")
      }
      is ViewState.Greeting -> println("Hello to you ${it.greeting}")
      is ViewState.Exit -> exitProcess(0)
    }
  }
  waitForEnter()
  events.onNext(Event.GreetingRequested)
  waitForEnter()
  events.onNext(Event.ExitRequested)

}

fun waitForEnter() =
  System.console()
    ?.run {
      printf("\nPress <Enter> to end\n")
      readLine()
    }
