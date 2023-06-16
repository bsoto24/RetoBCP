package pe.com.test.data.repository

import pe.com.test.data.datasource.MovieDS
import pe.com.test.domain.movie.entity.Movie
import javax.inject.Inject


/**
 * MovieRepositoryImpl
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
class MovieRepositoryImpl @Inject constructor(
    private val movieDS: MovieDS
) : MovieRepository {

    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return movieDS.getPopularMovies()
    }

    override suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return movieDS.getUpcomingMovies()
    }

}