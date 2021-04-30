package hu.laki.mobillab.ui.favourites

import co.zsmb.rainbowcake.withIOContext
import hu.laki.mobillab.domain.JokesInteractor
import hu.laki.mobillab.domain.model.Joke
import javax.inject.Inject

class FavouritesPresenter @Inject constructor(
        private val jokesInteractor: JokesInteractor
) {

    suspend fun getFavourites(): List<Joke> = withIOContext {
        return@withIOContext jokesInteractor.getFavouriteJokes()
    }

    suspend fun deleteFavouriteJoke(joke: Joke) = withIOContext {
        return@withIOContext jokesInteractor.deleteFavouriteJoke(joke)
    }

}
