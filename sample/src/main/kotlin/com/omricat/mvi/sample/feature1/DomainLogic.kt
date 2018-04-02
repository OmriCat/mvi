package com.omricat.mvi.sample.feature1

import com.omricat.mvi.Controller
import com.omricat.mvi.Reducer
import io.reactivex.Single
import io.reactivex.rxkotlin.ofType

sealed class Event {
  object GreetingRequested : Event()
  object ExitRequested : Event()
}

sealed class ViewState {
  object NoGreeting : ViewState()
  data class Greeting(val greeting: String) : ViewState()
  object Exit : ViewState()
}

fun greetingRequestedController(name: Single<String>)
    : Controller<Event, ViewState> =
  {
    it.ofType<Event.GreetingRequested>()
      .switchMap { name.toObservable().map(::greetingReducer) }
  }

fun exitRequestedController(): Controller<Event, ViewState> = {
  it.ofType<Event.ExitRequested>().map { { _: ViewState -> ViewState.Exit } }
}

internal fun greetingReducer(name: String): Reducer<ViewState> =
  { ViewState.Greeting(name) }
