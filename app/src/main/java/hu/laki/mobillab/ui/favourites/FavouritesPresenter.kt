package hu.laki.mobillab.ui.favourites

import co.zsmb.rainbowcake.withIOContext
import hu.laki.mobillab.domain.JokesInteractor
import javax.inject.Inject

class FavouritesPresenter @Inject constructor(
        private val jokesInteractor: JokesInteractor
) {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
