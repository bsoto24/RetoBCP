package pe.com.test.data.repository

import pe.com.test.domain.movie.entity.Movie


/**
 * MovieRepository
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
interface MovieRepository {

    suspend fun getPopularMovies(): Result<List<Movie>>

    suspend fun getUpcomingMovies(): Result<List<Movie>>

}