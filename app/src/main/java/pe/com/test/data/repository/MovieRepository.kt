package pe.com.test.data.repository

import pe.com.test.data.entity.MoviePopular
import pe.com.test.data.entity.MovieUpcoming


/**
 * MovieRepository
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
interface MovieRepository {

    suspend fun getPopularMovies(): Result<List<MoviePopular>>

    suspend fun getUpcomingMovies(): Result<List<MovieUpcoming>>

}