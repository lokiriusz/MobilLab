package hu.laki.mobillab.domain

import hu.laki.mobillab.data.local.LocalDataSource
import hu.laki.mobillab.data.network.NetworkDataSource
import hu.laki.mobillab.domain.model.Joke
import hu.laki.mobillab.domain.model.toDomainJoke
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource
) {

    suspend fun getRandomJoke(): Joke? {
        val response = networkDataSource.getRandomJoke() ?: return null
        return response.toDomainJoke(response)
    }

    suspend fun getFavouriteJokes(): List<Joke> {
        val response =  networkDataSource.getFavouriteJokes() ?: return emptyList()
        return response.map { it.toDomainJoke(it) }
    }

    suspend fun addFavouriteJoke(joke: Joke): List<Joke> {
        val response =  networkDataSource.addFavouriteJoke(joke.id) ?: return emptyList()
        return response.map { it.toDomainJoke(it) }
    }

    suspend fun deleteFavouriteJoke(joke: Joke): List<Joke> {
        val response =  networkDataSource.deleteFavouriteJoke(joke.id) ?: return emptyList()
        return response.map { it.toDomainJoke(it) }
    }

}
