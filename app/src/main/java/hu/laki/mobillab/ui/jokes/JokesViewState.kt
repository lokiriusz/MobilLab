package hu.laki.mobillab.ui.jokes

import hu.laki.mobillab.domain.model.Joke

sealed class JokesViewState

object LoadingJoke : JokesViewState()

data class JokeReady(val joke: Joke) : JokesViewState()

data class JokeFailure(val message: String) : JokesViewState()
