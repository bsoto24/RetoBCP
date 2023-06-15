package pe.com.test.data.datasource

import pe.com.test.data.entity.MoviePopular
import pe.com.test.data.entity.MovieUpcoming


/**
 * MovieDS
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
interface MovieDS {

    suspend fun getPopularMovies(): Result<List<MoviePopular>>

    suspend fun getUpcomingMovies(): Result<List<MovieUpcoming>>

}