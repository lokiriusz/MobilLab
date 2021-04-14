package hu.laki.mobillab.domain

import hu.laki.mobillab.data.network.NetworkDataSource
import hu.laki.mobillab.data.network.model.JokeDTO
import hu.laki.mobillab.domain.model.Joke
import hu.laki.mobillab.domain.model.toDomainJoke
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource
) {

    suspend fun getRandomJoke(): Joke? {
        val response: JokeDTO = networkDataSource.getRandomJoke() ?: return null
        return response.toDomainJoke(response)
    }

}
