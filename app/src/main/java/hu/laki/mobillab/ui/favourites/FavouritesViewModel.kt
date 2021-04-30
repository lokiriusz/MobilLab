package hu.laki.mobillab.ui.favourites

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(
    private val presenter: FavouritesPresenter
) : RainbowCakeViewModel<FavouritesViewState>(LoadingFavourites) {

    fun loadFavourites() = execute {
        viewState = FavouritesReady(presenter.getFavourites())
    }

}
