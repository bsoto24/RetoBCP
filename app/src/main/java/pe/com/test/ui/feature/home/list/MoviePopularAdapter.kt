package pe.com.test.ui.feature.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.com.test.common.BASE_URL_IMAGE
import pe.com.test.databinding.ItemMoviePopularBinding
import pe.com.test.domain.movie.entity.Movie

class MoviePopularAdapter(private val clickListener: (Movie) -> Unit) :
    ListAdapter<Movie, MoviePopularAdapter.MoviePopularViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePopularViewHolder =
        MoviePopularViewHolder.from(parent)

    override fun onBindViewHolder(holder: MoviePopularViewHolder, position: Int) {
        getItem(position).let { movie ->
            holder.bind(movie)
            holder.itemView.setOnClickListener {
                clickListener.invoke(movie)
            }
        }
    }

    class MoviePopularViewHolder(private val binding: ItemMoviePopularBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            Glide.with(binding.root.context)
                .load("$BASE_URL_IMAGE${movie.posterPath}")
                .into(binding.posterImageView)
        }

        companion object {

            fun from(parent: ViewGroup): MoviePopularViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMoviePopularBinding.inflate(layoutInflater, parent, false)
                return MoviePopularViewHolder(binding)
            }

        }
    }

}