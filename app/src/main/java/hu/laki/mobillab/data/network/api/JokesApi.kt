package hu.laki.mobillab.data.network.api

import retrofit2.http.*
import retrofit2.Response

import hu.laki.mobillab.data.network.model.JokeDTO

interface JokesApi {
    /**
     * Your GET endpoint
     * Retrieve a random chuck joke in JSON format.
     * Responses:
     *  - 200: OK
     * 
    * @return [JokeDTO]
     */
    @GET("jokes/random")
    suspend fun getRandomJoke(): Response<JokeDTO>

}
