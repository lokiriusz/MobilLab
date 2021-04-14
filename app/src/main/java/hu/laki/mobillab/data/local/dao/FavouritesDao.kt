package hu.laki.mobillab.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import hu.laki.mobillab.data.local.model.Joke

@Dao
interface FavouritesDao {

    @Query("SELECT * FROM Joke")
    suspend fun getFavourites(): List<Joke>

    @Insert
    suspend fun addFavouriteJoke(joke: Joke)

    @Delete
    suspend fun deleteFavouriteJoke(joke: Joke)

}