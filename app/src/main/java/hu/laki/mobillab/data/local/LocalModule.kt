package hu.laki.mobillab.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import hu.laki.mobillab.data.local.dao.FavouritesDao
import javax.inject.Singleton

@Module
class LocalModule {

    @Provides
    @Singleton
    fun provideFavouritesDatabase(context: Context): FavouritesDatabase {
        return Room.databaseBuilder(context.applicationContext, FavouritesDatabase::class.javaObjectType, "favourites-db").build()
    }

    @Provides
    @Singleton
    fun provideFavoritesDao(favouritesDatabase: FavouritesDatabase): FavouritesDao {
        return favouritesDatabase.favouritesDao()
    }

}