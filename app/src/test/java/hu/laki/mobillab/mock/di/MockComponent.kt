package hu.laki.mobillab.mock.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.laki.mobillab.data.local.LocalModule
import hu.laki.mobillab.di.ApplicationModule
import hu.laki.mobillab.di.ViewModelModule
import hu.laki.mobillab.mock.data.network.MockNetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        MockNetworkModule::class,
        LocalModule::class
    ]
)
interface MockComponent : RainbowCakeComponent
