package pe.com.test.domain.movie.usecase

import pe.com.test.data.repository.MovieRepository
import pe.com.test.domain.movie.entity.Movie
import javax.inject.Inject


/**
 * PopularMovieUC
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
class MoviePopularUC @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return movieRepository.getPopularMovies()
            .map { list -> list.sortedByDescending { it.popularity } }
    }

}