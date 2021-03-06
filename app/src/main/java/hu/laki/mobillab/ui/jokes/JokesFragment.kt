package hu.laki.mobillab.ui.jokes

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.google.android.material.snackbar.Snackbar
import hu.laki.mobillab.R
import hu.laki.mobillab.helpers.setToolbarTitle
import hu.laki.mobillab.ui.about.AboutFragment
import hu.laki.mobillab.ui.favourites.FavouritesFragment
import kotlinx.android.synthetic.main.fragment_jokes.*

class JokesFragment : RainbowCakeFragment<JokesViewState, JokesViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_jokes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle("Random Joke from Chuck")

        refreshJokeButton.setOnClickListener {
            viewModel.refreshJoke()
        }
        aboutButton.setOnClickListener {
            navigator?.add(AboutFragment())
        }
        addFavourites.setOnClickListener {
            viewModel.addJokeToFavourites()
            Snackbar.make(it,"Adding to favourites...",Snackbar.LENGTH_LONG).show()
        }
        showFavourites.setOnClickListener {
            navigator?.add(FavouritesFragment())
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadJoke()
    }

    override fun render(viewState: JokesViewState) {
        when (viewState) {
            is LoadingJoke -> {
                addFavourites.isVisible = false
                refreshJokeButton.isVisible = false
                progressBar.isVisible = true
            }
            is JokeReady -> {
                addFavourites.isVisible = true
                refreshJokeButton.isVisible = true
                progressBar.isVisible = false
                joke.text = viewState.joke.value
            }
            is JokeFailure -> {
                addFavourites.isVisible = false
                refreshJokeButton.isVisible = true
                progressBar.isVisible = false
                joke.text = viewState.message
            }
        }
    }

}
