package hu.laki.mobillab.ui.favourites

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.laki.mobillab.domain.model.Joke
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(
    private val presenter: FavouritesPresenter
) : RainbowCakeViewModel<FavouritesViewState>(FavouritesLoading) {

    fun loadFavourites() = execute {
        viewState = FavouritesLoading
        viewState = FavouritesReady(presenter.getFavourites())
    }

    fun deleteFavouriteJoke(joke: Joke) = execute {
        viewState = FavouritesLoading
        viewState = FavouritesReady(presenter.deleteFavouriteJoke(joke))
    }

}
