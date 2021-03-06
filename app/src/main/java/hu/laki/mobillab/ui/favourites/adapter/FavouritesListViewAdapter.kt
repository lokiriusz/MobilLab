package hu.laki.mobillab.ui.favourites.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.laki.mobillab.R
import hu.laki.mobillab.domain.model.Joke
import hu.laki.mobillab.ui.favourites.FavouritesViewModel
import kotlinx.android.synthetic.main.favourites_list_item.view.*

class FavouritesListAdapter(
        private val favourites: List<Joke>,
        private val deleteFavouriteJokeEvent: (Joke) -> Unit
): RecyclerView.Adapter<FavouritesListAdapter.FavouritesListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): FavouritesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favourites_list_item, parent, false)
        return FavouritesListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouritesListViewHolder, position: Int) {
        holder.favouriteJoke.text = favourites[position].value
        holder.deleteFavouriteJokeButton.setOnClickListener {
            deleteFavouriteJokeEvent(favourites[position])
        }
    }

    override fun getItemCount(): Int {
        return favourites.count()
    }


    inner class FavouritesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val favouriteJoke: TextView = itemView.favouriteJokeText
        val deleteFavouriteJokeButton: ImageButton = itemView.deleteButton
    }

}
