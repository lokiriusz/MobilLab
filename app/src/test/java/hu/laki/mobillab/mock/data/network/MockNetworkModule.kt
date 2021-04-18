package hu.laki.mobillab.mock.data.network

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import hu.laki.mobillab.data.network.api.FavouritesApi
import hu.laki.mobillab.data.network.api.JokesApi
import hu.laki.mobillab.mock.data.network.api.MockFavouritesAPI
import hu.laki.mobillab.mock.data.network.api.MockJokesAPI
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideJokesApi(): JokesApi {
        return MockJokesAPI()
    }

    @Provides
    @Singleton
    fun provideFavouritesApi(): FavouritesApi {
        return MockFavouritesAPI()
    }

}
