package hu.laki.mobillab.ui.favourites

import androidx.recyclerview.widget.LinearLayoutManager
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.laki.mobillab.R
import hu.laki.mobillab.helpers.setToolbarTitle
import hu.laki.mobillab.ui.favourites.adapter.FavouritesListAdapter
import kotlinx.android.synthetic.main.fragment_favourites.*

class FavouritesFragment : RainbowCakeFragment<FavouritesViewState, FavouritesViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_favourites

    override fun onStart() {
        super.onStart()

        setToolbarTitle("Favourite Jokes", true)

        viewModel.loadFavourites()
    }

    override fun render(viewState: FavouritesViewState) {
        when (viewState) {
            is LoadingFavourites -> {

            }
            is FavouritesReady -> {
                listView.layoutManager = LinearLayoutManager(context)
                listView.adapter = FavouritesListAdapter(viewState.favouriteJokes)
            }
        }
    }

}
