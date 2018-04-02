package com.omricat.mvi

import com.jakewharton.rx.ReplayingShare
import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.Relay
import com.omricat.kommons.applyIf
import io.reactivex.Observable

interface LogicController<E, T> : Function<T> {
  fun accept(events: Observable<in E>): Observable<out T>
}

class StandardLogicController<E, T>(
  private val initialState: T,
  skipInitialEmission: Boolean = false,
  private val controller: Controller<E, T>
) : LogicController<E, T> {

  private val uiEvents: Relay<Observable<in E>> = BehaviorRelay.create()

  private val viewState: Observable<T> = uiEvents
    .switchMap { uiEvents ->
      controller(uiEvents)
        .scan(initialState) { state, reducer ->
          reducer(state)
        }
        .applyIf(skipInitialEmission) { skip(1) }
    }
    .distinctUntilChanged()
    .compose(ReplayingShare.instance())

  override fun accept(events: Observable<in E>): Observable<out T> {
    uiEvents.accept(events)
    return viewState
  }

}

fun <E, T> listLogicController(
  controllers: List<Controller<E, T>>,
  initialState: T
): LogicController<E, T> =
  StandardLogicController(initialState) {
    it.publish { uiEvents ->
      Observable.merge(
        controllers.map { controller -> controller(uiEvents) }
      )
    }
  }

typealias Controller<T, S> = (Observable<in T>) -> Observable<out Reducer<S>>

typealias Reducer<T> = (T) -> T


