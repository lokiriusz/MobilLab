package hu.laki.mobillab.ui.about

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class AboutViewModel @Inject constructor(
    private val presenter: AboutPresenter
) : RainbowCakeViewModel<AboutViewState>(Loading) {

    fun load() = execute {
        viewState = AboutReady(presenter.getData())
    }

}
