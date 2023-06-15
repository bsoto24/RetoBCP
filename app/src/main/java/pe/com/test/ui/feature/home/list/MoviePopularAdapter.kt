package pe.com.test.ui.feature.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.com.test.data.datasource.remote.entity.MoviePopular
import pe.com.test.databinding.ItemMoviePopularBinding

class MoviePopularAdapter(private val clickListener: (MoviePopular) -> Unit) :
    ListAdapter<MoviePopular, MoviePopularAdapter.MoviePopularViewHolder>(MoviePopularDiffCallback()) {

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
        fun bind(moviePopular: MoviePopular) {
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w185/${moviePopular.posterPath}")
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

    class MoviePopularDiffCallback : DiffUtil.ItemCallback<MoviePopular>() {

        override fun areItemsTheSame(oldItem: MoviePopular, newItem: MoviePopular): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MoviePopular, newItem: MoviePopular): Boolean {
            return oldItem == newItem
        }

    }
}