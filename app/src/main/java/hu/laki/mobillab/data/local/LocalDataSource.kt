package hu.laki.mobillab.data.local

import hu.laki.mobillab.data.local.dao.FavouritesDao
import hu.laki.mobillab.data.local.model.Joke
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val favouritesDao: FavouritesDao
) {

    suspend fun getFavouriteJokes(): List<Joke> {
        return favouritesDao.getFavourites()
    }

    suspend fun addFavouriteJoke(joke: Joke): List<Joke> {
        favouritesDao.addFavouriteJoke(joke)
        return getFavouriteJokes()
    }

    suspend fun deleteFavouriteJoke(joke: Joke): List<Joke> {
        favouritesDao.deleteFavouriteJoke(joke)
        return getFavouriteJokes()
    }

}