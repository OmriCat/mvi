package com.omricat.mvi.sample.feature1

import com.omricat.mvi.LogicController
import com.omricat.mvi.ViewBindingComponent
import com.omricat.mvi.ViewBindingModule
import com.omricat.mvi.listLogicController
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.Single

@Subcomponent(
  modules = [Feature1Module::class]
)
interface Feature1Component : ViewBindingComponent<Event, ViewState>

@Module
class Feature1Module : ViewBindingModule<Event, ViewState>() {

  @Provides
  fun logicController(name: Single<String>): LogicController<Event, ViewState> =
    listLogicController(
      initialState = ViewState.NoGreeting,
      controllers = listOf(
        greetingRequestedController(name), exitRequestedController()
      )
    )


}

