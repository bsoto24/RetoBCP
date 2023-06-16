package pe.com.test.data.datasource

import pe.com.test.domain.movie.entity.Movie


/**
 * MovieDS
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
interface MovieDS {

    suspend fun getPopularMovies(page: Int): Result<List<Movie>>

    suspend fun getUpcomingMovies(page: Int): Result<List<Movie>>

}