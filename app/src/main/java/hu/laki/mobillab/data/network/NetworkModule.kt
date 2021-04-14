package hu.laki.mobillab.data.network

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import hu.laki.mobillab.data.network.api.FavouritesApi
import hu.laki.mobillab.data.network.api.JokesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {
    companion object {
        const val BASE_URL = "https://api.chucknorris.io/"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideJokesApi(retrofit: Retrofit): JokesApi {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideFavouritesApi(retrofit: Retrofit): FavouritesApi {
        return retrofit.create()
    }

}
