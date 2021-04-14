package hu.laki.mobillab.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.laki.mobillab.data.local.dao.FavouritesDao
import hu.laki.mobillab.data.local.model.Joke

@Database(entities = [Joke::class], version = 1)
abstract class FavouritesDatabase: RoomDatabase() {

    abstract fun favouritesDao(): FavouritesDao

}
