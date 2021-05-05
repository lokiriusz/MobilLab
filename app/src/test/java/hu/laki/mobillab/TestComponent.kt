package hu.laki.mobillab

import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.laki.mobillab.di.AppComponent
import hu.laki.mobillab.di.ViewModelModule
import hu.laki.mobillab.mock.data.local.MockLocalModule
import hu.laki.mobillab.mock.data.network.MockNetworkModule
import hu.laki.mobillab.test.InteractorTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ViewModelModule::class,
        MockNetworkModule::class,
        MockLocalModule::class
    ]
)
@ExperimentalCoroutinesApi
interface TestComponent : AppComponent {
        fun inject(interactorTest: InteractorTest)
}