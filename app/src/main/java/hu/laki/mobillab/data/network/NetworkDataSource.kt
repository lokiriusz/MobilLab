package hu.laki.mobillab.data.network

import hu.laki.mobillab.data.network.api.FavouritesApi
import hu.laki.mobillab.data.network.api.JokesApi
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
        private val jokesApi: JokesApi,
        private val favouritesApi: FavouritesApi
) {

}
