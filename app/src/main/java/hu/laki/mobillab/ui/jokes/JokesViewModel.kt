package hu.laki.mobillab.ui.jokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class JokesViewModel @Inject constructor(
    private val presenter: JokesPresenter
) : RainbowCakeViewModel<JokesViewState>(LoadingJoke) {

    fun loadJoke() = execute {
        refreshJoke()
    }

    fun refreshJoke() = execute {
        viewState = LoadingJoke
        val newJoke = presenter.getRandomJoke()
        viewState = when(newJoke == null) {
            true -> JokeFailure("Failure during refreshing!")
            false -> JokeReady(newJoke)
        }
    }

}
