package hu.laki.mobillab

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.robolectric.shadows.ShadowLog

@ExperimentalCoroutinesApi
val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        return DaggerTestComponent.builder().build()
    }