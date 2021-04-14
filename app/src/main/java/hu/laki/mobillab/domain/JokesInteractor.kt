package hu.laki.mobillab.domain

import hu.laki.mobillab.data.local.LocalDataSource
import hu.laki.mobillab.data.local.model.toLocalJoke
import hu.laki.mobillab.data.network.NetworkDataSource
import hu.laki.mobillab.domain.model.Joke
import hu.laki.mobillab.data.local.model.Joke as LocalJoke
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
        return response.toDomainJoke()
    }

    suspend fun getFavouriteJokes(): List<Joke> {
        val response =  localDataSource.getFavouriteJokes()
        return response.map { it.toDomainJoke() }
    }

    suspend fun addFavouriteJoke(joke: Joke): List<Joke> {
        val response =  localDataSource.addFavouriteJoke(joke.toLocalJoke())
        return response.map { it.toDomainJoke() }
    }

    suspend fun deleteFavouriteJoke(joke: Joke): List<Joke> {
        val response =  localDataSource.deleteFavouriteJoke(joke.toLocalJoke())
        return response.map { it.toDomainJoke() }
    }

}
