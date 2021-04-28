package hu.laki.mobillab.ui.jokes

import co.zsmb.rainbowcake.withIOContext
import hu.laki.mobillab.domain.JokesInteractor
import hu.laki.mobillab.domain.model.Joke
import javax.inject.Inject

class JokesPresenter @Inject constructor(
        private val jokesInteractor: JokesInteractor
) {
    private var joke: Joke? = null

    suspend fun getRandomJoke(): Joke? = withIOContext {
        joke = jokesInteractor.getRandomJoke()
        return@withIOContext joke
    }

    suspend fun addJokeToFavourites() = withIOContext {
        joke?.let { jokesInteractor.addFavouriteJoke(it) }
    }

}
