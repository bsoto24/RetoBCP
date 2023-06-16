package pe.com.test.data.datasource

import pe.com.test.data.datasource.remote.api.MovieApi
import pe.com.test.data.datasource.remote.utils.parseApiCall
import pe.com.test.domain.movie.entity.Movie
import pe.com.test.domain.movie.mapper.toDomain
import javax.inject.Inject


/**
 * MovieDSImpl
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
class MovieDSImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieDS {

    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return parseApiCall {
            movieApi.popularMovies("1", "en-US")
        }.map { response ->
            response.results.map { it.toDomain() }
        }
    }

    override suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return parseApiCall {
            movieApi.upcomingMovies("1", "en-US")
        }.map { response ->
            response.results.map { it.toDomain() }
        }
    }
}