package com.omricat.mvi.sample.feature2

import com.omricat.mvi.*
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(
  modules = [Feature2Module::class]
)
interface Feature2Component : ViewBindingComponent<Event, ViewState>

@Module
class Feature2Module : ViewBindingModule<Event, ViewState>() {

  @Provides
  fun logicController(catRepository: CatRepository)
      : LogicController<Event, ViewState> {
    return listLogicController(
      initialState = ViewState.NoCat,
      controllers = listOf<Controller<in Event, ViewState>>(
        catAddedController(catRepository),
        catRemovedController(catRepository)
      )
    )
  }


}
