package hu.laki.mobillab.ui.jokes

sealed class JokesViewState

object Loading : JokesViewState()

data class JokesReady(val data: String = "") : JokesViewState()
