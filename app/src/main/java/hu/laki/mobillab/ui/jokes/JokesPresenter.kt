package hu.laki.mobillab.ui.jokes

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class JokesPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
