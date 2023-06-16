package pe.com.test.ui.feature.home.list

import androidx.recyclerview.widget.DiffUtil
import pe.com.test.domain.movie.entity.Movie


/**
 * MovieDiffCallback
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}