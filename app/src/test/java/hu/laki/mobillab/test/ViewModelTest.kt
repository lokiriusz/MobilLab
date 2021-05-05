package hu.laki.mobillab.test

import co.zsmb.rainbowcake.test.assertObserved
import co.zsmb.rainbowcake.test.observeStateAndEvents
import hu.laki.mobillab.domain.model.Joke
import hu.laki.mobillab.mock.domain.mockJoke
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
    fun `test joke is retrieved on load`() = runBlockingTest {
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
    fun `test joke is not retrieved on load`() = runBlockingTest {
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

}
