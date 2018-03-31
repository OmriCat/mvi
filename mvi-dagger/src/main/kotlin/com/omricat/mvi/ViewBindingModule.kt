package com.omricat.mvi

import dagger.Module
import dagger.Provides

interface ViewBindingComponent<E, S> {
  val binder: ViewBinder<E, S>
  val unbinder: ViewUnbinder
}

@Module
abstract class ViewBindingModule<E, S> {

  @Provides
  fun viewBinder(instance: StandardViewBinder<E, S>): ViewBinder<E, S> =
    instance

  @Provides
  fun viewUnbinder(instance: StandardViewBinder<E, S>): ViewUnbinder = instance

  @Provides
  fun standardLoginBinder(logicController: LogicController<E, S>)
      : StandardViewBinder<E, S> = StandardViewBinder(logicController)
}
