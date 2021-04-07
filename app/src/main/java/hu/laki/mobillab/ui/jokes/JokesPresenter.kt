package hu.laki.mobillab.ui.jokes

import co.zsmb.rainbowcake.withIOContext
import hu.laki.mobillab.domain.JokesInteractor
import javax.inject.Inject

class JokesPresenter @Inject constructor(
        private val jokesInteractor: JokesInteractor
) {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
