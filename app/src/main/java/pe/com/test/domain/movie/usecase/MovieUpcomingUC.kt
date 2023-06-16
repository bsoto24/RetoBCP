package pe.com.test.domain.movie.usecase

import pe.com.test.data.repository.MovieRepository
import pe.com.test.domain.movie.entity.Movie
import pe.com.test.ui.util.notReleasedYet
import pe.com.test.ui.util.toDate
import javax.inject.Inject


/**
 * PopularMovieUC
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
class MovieUpcomingUC @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return movieRepository.getUpcomingMovies().map { list ->
            list.filter { notReleasedYet(it.releaseDate) }.sortedBy { it.releaseDate.toDate() }
        }
    }

}