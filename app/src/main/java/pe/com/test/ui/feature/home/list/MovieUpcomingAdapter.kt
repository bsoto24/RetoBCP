package pe.com.test.ui.feature.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.com.test.common.BASE_URL_IMAGE
import pe.com.test.databinding.ItemMovieUpcomingBinding
import pe.com.test.domain.movie.entity.Movie

class MovieUpcomingAdapter(private val clickListener: (Movie) -> Unit) :
    ListAdapter<Movie, MovieUpcomingAdapter.MovieUpcomingViewHolder>(
        MovieDiffCallback()
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
        fun bind(movieUpcomingResponse: Movie) {
            Glide.with(binding.root.context)
                .load("$BASE_URL_IMAGE${movieUpcomingResponse.posterPath}")
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

}