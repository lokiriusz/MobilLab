package hu.laki.mobillab.mock.data.network.api

import hu.laki.mobillab.data.network.api.FavouritesApi
import hu.laki.mobillab.data.network.model.JokeDTO
import retrofit2.Response

class MockFavouritesAPI: FavouritesApi {
    override suspend fun deleteFavouriteJoke(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavourites(): Response<List<JokeDTO>> {
        TODO("Not yet implemented")
    }

    override suspend fun postFavouriteJoke(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }

}
