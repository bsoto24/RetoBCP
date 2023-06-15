package pe.com.test.ui.feature.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.com.test.data.datasource.remote.entity.MovieUpcoming
import pe.com.test.databinding.ItemMovieUpcomingBinding

class MovieUpcomingAdapter(private val clickListener: (MovieUpcoming) -> Unit) :
    ListAdapter<MovieUpcoming, MovieUpcomingAdapter.MovieUpcomingViewHolder>(
        MovieUpcomingDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieUpcomingViewHolder =
        MovieUpcomingViewHolder.from(parent)

    override fun onBindViewHolder(holder: MovieUpcomingViewHolder, position: Int) {
        getItem(position).let { movie ->
            holder.bind(movie)
            holder.itemView.setOnClickListener {
                clickListener.invoke(movie)
            }
        }
    }

    class MovieUpcomingViewHolder(private val binding: ItemMovieUpcomingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieUpcoming: MovieUpcoming) {
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w185/${movieUpcoming.posterPath}")
                .into(binding.posterImageView)
        }

        companion object {

            fun from(parent: ViewGroup): MovieUpcomingViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMovieUpcomingBinding.inflate(layoutInflater, parent, false)
                return MovieUpcomingViewHolder(binding)
            }

        }
    }

    class MovieUpcomingDiffCallback : DiffUtil.ItemCallback<MovieUpcoming>() {

        override fun areItemsTheSame(oldItem: MovieUpcoming, newItem: MovieUpcoming): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieUpcoming, newItem: MovieUpcoming): Boolean {
            return oldItem == newItem
        }

    }

}