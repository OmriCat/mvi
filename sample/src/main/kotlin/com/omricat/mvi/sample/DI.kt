package com.omricat.mvi.sample

import com.omricat.mvi.LogicController
import com.omricat.mvi.ViewBindingComponent
import com.omricat.mvi.ViewBindingModule
import com.omricat.mvi.listLogicController
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.Single

@Component(modules = [MviSampleModule::class])
interface MviSampleComponent: ViewBindingComponent<Event, ViewState>

@Module
class MviSampleModule : ViewBindingModule<Event, ViewState>() {

  @Provides
  fun logicController(name: Single<String>): LogicController<Event, ViewState> =
    listLogicController(
      initialState = ViewState.NoGreeting,
      controllers = listOf(greetingRequestedController(name), exitRequestedController)
    )

  @Provides
  fun name(): Single<String> = Single.just("Dave")
}

fun component() = DaggerMviSampleComponent.create()
