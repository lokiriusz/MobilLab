package hu.laki.mobillab.mock.data.network.api

import hu.laki.mobillab.data.network.api.JokesApi
import hu.laki.mobillab.data.network.model.JokeDTO
import hu.laki.mobillab.mock.data.network.model.mockJokeDTO
import retrofit2.Response

class MockJokesAPI: JokesApi {
    override suspend fun getRandomJoke(): Response<JokeDTO> {
        return Response.success(mockJokeDTO())
    }

}