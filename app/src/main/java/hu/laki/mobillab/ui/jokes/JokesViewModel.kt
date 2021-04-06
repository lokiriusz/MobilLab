package hu.laki.mobillab.ui.jokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class JokesViewModel @Inject constructor(
    private val presenter: JokesPresenter
) : RainbowCakeViewModel<JokesViewState>(Loading) {

    fun load() = execute {
        viewState = JokesReady(presenter.getData())
    }

}
