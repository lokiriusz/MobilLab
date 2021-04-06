package hu.laki.mobillab.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hu.laki.mobillab.ui.about.AboutViewModel
import hu.laki.mobillab.ui.favourites.FavouritesViewModel
import hu.laki.mobillab.ui.jokes.JokesViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(JokesViewModel::class)
    abstract fun bindJokesViewModel(jokesVewModel: JokesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouritesViewModel::class)
    abstract fun bindFavouritesViewModel(favouritesViewModel: FavouritesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindAboutViewModel(aboutViewModel: AboutViewModel): ViewModel

}
