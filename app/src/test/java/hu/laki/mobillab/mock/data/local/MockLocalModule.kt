package hu.laki.mobillab.mock.data.local

import dagger.Module
import dagger.Provides
import hu.laki.mobillab.data.local.dao.FavouritesDao
import hu.laki.mobillab.mock.data.local.dao.MockFavouritesDao
import javax.inject.Singleton

@Module
class MockLocalModule {
    @Provides
    @Singleton
    fun provideFavoritesDao(): FavouritesDao {
        return MockFavouritesDao()
    }

}