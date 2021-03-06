package hu.laki.mobillab.data.network

import hu.laki.mobillab.data.network.api.FavouritesApi
import hu.laki.mobillab.data.network.api.JokesApi
import hu.laki.mobillab.data.network.model.JokeDTO
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
        private val jokesApi: JokesApi,
        private val favouritesApi: FavouritesApi
) {

        suspend fun getRandomJoke(): JokeDTO? {
                return jokesApi.getRandomJoke().body()
        }

        suspend fun getFavouriteJokes(): List<JokeDTO>? {
                return null
        }

        suspend fun addFavouriteJoke(jokeId: String): List<JokeDTO>? {
                return null
        }

        suspend fun deleteFavouriteJoke(jokeId: String): List<JokeDTO>? {
                return null
        }

}
