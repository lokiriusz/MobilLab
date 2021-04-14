package hu.laki.mobillab.data.network.api

import retrofit2.http.*
import retrofit2.Response

import hu.laki.mobillab.data.network.model.JokeDTO

interface FavouritesApi {
    /**
     * 
     * Delete joke from favourites.
     * Responses:
     *  - 200: OK
     * 
     * @param id  
    * @return [Unit]
     */
    @DELETE("favourites/{id}")
    suspend fun deleteFavouriteJoke(@Path("id") id: kotlin.String): Response<Unit>

    /**
     * Your GET endpoint
     * Retrieve favourite jokes in JSON format.
     * Responses:
     *  - 200: OK
     * 
    * @return [kotlin.collections.List<JokeDTO>]
     */
    @GET("favourites")
    suspend fun getFavourites(): Response<kotlin.collections.List<JokeDTO>>

    /**
     * 
     * Add a joke to favourites.
     * Responses:
     *  - 200: OK
     * 
     * @param id  
    * @return [Unit]
     */
    @POST("favourites/{id}")
    suspend fun postFavouriteJoke(@Path("id") id: kotlin.String): Response<Unit>

}
