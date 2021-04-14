package hu.laki.mobillab.ui.jokes

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.laki.mobillab.R
import hu.laki.mobillab.helpers.setToolbarTitle
import kotlinx.android.synthetic.main.fragment_jokes.*

class JokesFragment : RainbowCakeFragment<JokesViewState, JokesViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_jokes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle("Random Joke from Chuck")
        refreshJoke.setOnClickListener {
            viewModel.refreshJoke()
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadJoke()
    }

    override fun render(viewState: JokesViewState) {
        when (viewState) {
            is LoadingJoke -> {
                refreshJoke.isVisible = false
                progressBar.isVisible = true
            }
            is JokeReady -> {
                refreshJoke.isVisible = true
                progressBar.isVisible = false
                joke.text = viewState.joke.value
            }
            is JokeFailure -> {
                refreshJoke.isVisible = true
                progressBar.isVisible = false
                joke.text = viewState.message
            }
        }
    }

}
