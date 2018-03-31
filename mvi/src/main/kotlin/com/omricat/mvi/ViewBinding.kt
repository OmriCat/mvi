package com.omricat.mvi

import io.reactivex.Observable
import javax.inject.Inject

interface ViewBinder<E, S> {
  fun bind(uiEvents: Observable<E>): Observable<out S>
  operator fun invoke(uiEvents: Observable<E>): Observable<out S>
}

interface ViewUnbinder {
  fun unbind()
  operator fun invoke()
}

class StandardViewBinder<E, S>
@Inject constructor(
  private val logicController: LogicController<E, S>
) :
  ViewBinder<E, S>, ViewUnbinder {

  override fun bind(uiEvents: Observable<E>): Observable<out S> =
    logicController.accept(uiEvents)

  override fun unbind() {
    logicController.accept(Observable.never())
  }

  override operator fun invoke(uiEvents: Observable<E>): Observable<out S> =
    bind(uiEvents)

  override operator fun invoke() = unbind()
}
