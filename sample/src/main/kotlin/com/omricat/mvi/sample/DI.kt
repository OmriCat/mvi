package com.omricat.mvi.sample

import com.omricat.mvi.sample.feature1.Feature1Component
import com.omricat.mvi.sample.feature2.CatRepository
import com.omricat.mvi.sample.feature2.DefaultCatRepository
import com.omricat.mvi.sample.feature2.Feature2Component
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.Single

@Component(modules = [DataModule::class])
interface MviSampleComponent {
  val feature1Component: Feature1Component
  val feature2Component: Feature2Component
}


@Module
class DataModule {

  @Provides
  fun catRepository(instance: DefaultCatRepository): CatRepository =
    instance

  @Provides
  fun name(): Single<String> = Single.just("Dave")
}
