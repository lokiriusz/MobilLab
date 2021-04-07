package hu.laki.mobillab.domain

import hu.laki.mobillab.data.network.NetworkDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource
) {

}
