package hu.laki.mobillab.test

import hu.laki.mobillab.domain.JokesInteractor
import hu.laki.mobillab.domain.model.Joke
import hu.laki.mobillab.mock.domain.mockJoke
import hu.laki.mobillab.mock.domain.mockJokeWith
import hu.laki.mobillab.testInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class InteractorTest {
    @Inject
    lateinit var jokesInteractor: JokesInteractor

    @Before
    fun setup() {
        testInjector.inject(this)
    }

    @Test
    fun `test random joke retrieves`() = runBlockingTest {
        val actualRandomJoke = jokesInteractor.getRandomJoke()
        val expectedRandomJoke = mockJoke()

        Assert.assertNotNull(expectedRandomJoke)
        Assert.assertEquals(expectedRandomJoke, actualRandomJoke)
    }

    @Test
    fun `test favourites jokes retrieves`() = runBlockingTest {
        val actualFavouriteJokes = jokesInteractor.getFavouriteJokes()
        val expectedFavouriteJokes: List<Joke> = listOf(
                mockJokeWith("mockFavouriteJoke1"),
                mockJokeWith("mockFavouriteJoke2"),
                mockJokeWith("mockFavouriteJoke3")
        )

        Assert.assertEquals(actualFavouriteJokes, expectedFavouriteJokes)
    }

    @Test
    fun `test favourites joke deletes`() = runBlockingTest {
        val deletableFavouriteJoke = mockJokeWith("mockFavouriteJoke1")

        val actualFavouriteJokes = jokesInteractor.deleteFavouriteJoke(deletableFavouriteJoke)
        val expectedFavouriteJokes: List<Joke> = listOf(
                mockJokeWith("mockFavouriteJoke2"),
                mockJokeWith("mockFavouriteJoke3")
        )

        Assert.assertEquals(actualFavouriteJokes, expectedFavouriteJokes)
    }

    @Test
    fun `test favourites joke adding`() = runBlockingTest {
        val addableFavouriteJoke = mockJokeWith("mockNewFavouriteJoke")

        val actualFavouriteJokes = jokesInteractor.addFavouriteJoke(addableFavouriteJoke)
        val expectedFavouriteJokes: List<Joke> = listOf(
                mockJokeWith("mockFavouriteJoke1"),
                mockJokeWith("mockFavouriteJoke2"),
                mockJokeWith("mockFavouriteJoke3"),
                addableFavouriteJoke
        )

        Assert.assertEquals(actualFavouriteJokes, expectedFavouriteJokes)
    }

}