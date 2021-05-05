package hu.laki.mobillab.mock.data.local.dao

import hu.laki.mobillab.data.local.dao.FavouritesDao
import hu.laki.mobillab.data.local.model.Joke
import hu.laki.mobillab.mock.data.local.model.mockJokeWith

class MockFavouritesDao: FavouritesDao {

    private val mockFavouriteJokes: MutableList<Joke> = mutableListOf(
            mockJokeWith("mockFavouriteJoke1"),
            mockJokeWith("mockFavouriteJoke2"),
            mockJokeWith("mockFavouriteJoke3")
    )

    override suspend fun getFavourites(): List<Joke> {
        return mockFavouriteJokes
    }

    override suspend fun addFavouriteJoke(joke: Joke) {
        mockFavouriteJokes.add(joke)
    }

    override suspend fun deleteFavouriteJoke(joke: Joke) {
        mockFavouriteJokes.remove(joke)
    }

}