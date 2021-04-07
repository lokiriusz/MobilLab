package hu.laki.mobillab.data.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
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
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    fun provideChuckNorrisApi(retrofit: Retrofit): ChuckNorrisAPI {
        return retrofit.create()
    }

}
