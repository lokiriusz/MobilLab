package hu.laki.mobillab.data.network

import javax.inject.Inject

class NetworkDataSource @Inject constructor(
        private val chuckNorrisAPI: ChuckNorrisAPI
) {

}
