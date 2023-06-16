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

    override suspend fun getPopularMovies(page: Int): Result<List<Movie>> {
        return parseApiCall {
            movieApi.popularMovies(page, "en-US")
        }.map { response ->
            response.results?.map { it.toDomain() } ?: listOf()
        }
    }

    override suspend fun getUpcomingMovies(page: Int): Result<List<Movie>> {
        return parseApiCall {
            movieApi.upcomingMovies(page, "en-US")
        }.map { response ->
            response.results?.map { it.toDomain() } ?: listOf()
        }
    }
}