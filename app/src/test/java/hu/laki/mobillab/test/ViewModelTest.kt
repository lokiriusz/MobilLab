package hu.laki.mobillab.test

import co.zsmb.rainbowcake.test.assertObserved
import co.zsmb.rainbowcake.test.observeStateAndEvents
import hu.laki.mobillab.domain.model.Joke
import hu.laki.mobillab.mock.domain.mockJoke
import hu.laki.mobillab.mock.domain.mockJokeWith
import hu.laki.mobillab.ui.favourites.FavouritesLoading
import hu.laki.mobillab.ui.favourites.FavouritesPresenter
import hu.laki.mobillab.ui.favourites.FavouritesReady
import hu.laki.mobillab.ui.favourites.FavouritesViewModel
import hu.laki.mobillab.ui.jokes.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub
import org.robolectric.RobolectricTestRunner

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class ViewModelTest {

    @Test
    fun `test joke is retrieved`() = runBlockingTest {
        val joke: Joke = mockJoke()
        val presenter: JokesPresenter = mock()
        presenter.stub {
            onBlocking { getRandomJoke() } doReturn joke
        }

        val viewModel: JokesViewModel = JokesViewModel(presenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.loadJoke()

            stateObserver.assertObserved(
                    LoadingJoke,
                    JokeReady(joke)
            )
        }
    }

    @Test
    fun `test joke can be refreshed`() = runBlockingTest {
        val joke: Joke = mockJoke()
        val presenter: JokesPresenter = mock()
        presenter.stub {
            onBlocking { getRandomJoke() } doReturn joke
        }

        val viewModel: JokesViewModel = JokesViewModel(presenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.refreshJoke()

            stateObserver.assertObserved(
                    LoadingJoke,
                    JokeReady(joke)
            )
        }
    }

    @Test
    fun `test joke is not retrieved`() = runBlockingTest {
        val joke: Joke? = null
        val presenter: JokesPresenter = mock()
        presenter.stub {
            onBlocking { getRandomJoke() } doReturn joke
        }

        val viewModel: JokesViewModel = JokesViewModel(presenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.refreshJoke()

            stateObserver.assertObserved(
                    LoadingJoke,
                    JokeFailure("Failure during refreshing!")
            )
        }
    }

    @Test
    fun `test add joke to favourite jokes`() = runBlockingTest {
        val joke: Joke = mockJoke()
        val presenter: JokesPresenter = mock()
        presenter.stub {
            onBlocking { getRandomJoke() } doReturn joke
        }

        val viewModel: JokesViewModel = JokesViewModel(presenter)
        viewModel.loadJoke()
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.addJokeToFavourites()

            stateObserver.assertObserved(
                    JokeReady(joke)
            )
        }
    }


    @Test
    fun `test favourite jokes are retrieved`() = runBlockingTest {
        val jokes: List<Joke> = listOf(
                mockJokeWith("mockFavouriteJoke1"),
                mockJokeWith("mockFavouriteJoke2"),
                mockJokeWith("mockFavouriteJoke3")
        )
        val presenter: FavouritesPresenter = mock()
        presenter.stub {
            onBlocking { getFavourites() } doReturn jokes
        }

        val viewModel: FavouritesViewModel = FavouritesViewModel(presenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.loadFavourites()

            stateObserver.assertObserved(
                    FavouritesLoading,
                    FavouritesReady(jokes)
            )
        }
    }

    @Test
    fun `test a favourite joke is deleted`() = runBlockingTest {
        val deletableJoke: Joke = mockJokeWith("mockFavouriteJoke1")
        val presenter: FavouritesPresenter = mock()
        presenter.stub {
            onBlocking { getFavourites() } doReturn listOf(
                    deletableJoke,
                    mockJokeWith("mockFavouriteJoke2"),
                    mockJokeWith("mockFavouriteJoke3")
            )
            onBlocking { deleteFavouriteJoke(deletableJoke) } doReturn listOf(
                    mockJokeWith("mockFavouriteJoke2"),
                    mockJokeWith("mockFavouriteJoke3")
            )
        }

        val viewModel: FavouritesViewModel = FavouritesViewModel(presenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.deleteFavouriteJoke(mockJokeWith("mockFavouriteJoke1"))

            stateObserver.assertObserved(
                    FavouritesLoading,
                    FavouritesReady(
                            listOf(
                                    mockJokeWith("mockFavouriteJoke2"),
                                    mockJokeWith("mockFavouriteJoke3")
                            )
                    )
            )
        }
    }

}
