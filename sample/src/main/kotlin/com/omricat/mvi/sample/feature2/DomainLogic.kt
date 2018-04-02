package com.omricat.mvi.sample.feature2

import com.omricat.mvi.Controller
import com.omricat.mvi.Reducer
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

sealed class Event {
  data class CatAdded(val cat: String) : Event()
  data class CatRemoved(val cat: String) : Event()
}

sealed class ViewState {
  object NoCat : ViewState()
  data class HasCats(val cats: Set<String>) : ViewState()
}

interface CatRepository {
  fun addCat(cat: String): Single<Set<String>>
  fun removeCat(cat: String): Single<Set<String>>
}

class DefaultCatRepository @Inject constructor() : CatRepository {
  private val cats: MutableSet<String> = mutableSetOf()

  override fun addCat(cat: String): Single<Set<String>> =
    Single.just(cats.apply { add(cat) }.toSet())

  override fun removeCat(cat: String): Single<Set<String>> =
    Single.just(cats.apply { remove(cat) }.toSet())
}

fun catAddedController(catRepository: CatRepository)
    : Controller<Event.CatAdded, ViewState> =
  typeController {
    switchMap { it: Event.CatAdded ->
      catRepository
        .addCat(it.cat)
        .toObservable()

    }
      .map(::catsReducer)
  }

fun catRemovedController(catRepository: CatRepository)
    : Controller<Event.CatRemoved, ViewState> =
  typeController {
    flatMap { it: Event.CatRemoved ->
      catRepository
        .removeCat(it.cat)
        .toObservable()
    }.map(::catsReducer)
  }

private fun catsReducer(cats: Set<String>): Reducer<ViewState> =
  { _ ->
    when (cats.size) {
      0 -> ViewState.NoCat
      else -> ViewState.HasCats(cats)
    }
  }


inline fun <reified T : E, E : Any, S> typeController(
  crossinline block: Observable<T>.() -> Observable<Reducer<S>>
): Controller<E, S> =
  { events: Observable<in E> -> events.ofType(T::class.java).block() }
