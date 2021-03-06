package hu.laki.mobillab.ui.favourites

import hu.laki.mobillab.domain.model.Joke

sealed class FavouritesViewState

object FavouritesLoading : FavouritesViewState()

data class FavouritesReady(val favouriteJokes: List<Joke>) : FavouritesViewState()
