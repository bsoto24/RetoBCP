package pe.com.test.data.datasource

import pe.com.test.data.datasource.remote.api.MovieApi
import pe.com.test.data.entity.MoviePopular
import pe.com.test.data.entity.MovieUpcoming
import pe.com.test.data.mapper.toDomain
import java.io.IOException
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

    override suspend fun getPopularMovies(): Result<List<MoviePopular>> {
        val response = movieApi.popularMovies("d9ae4921794c06bd0fdbd1463d274804", "1", "en-US")
        if (response.isSuccessful) {
            response.body()?.results?.let { list ->
                return Result.success(list.map { it.toDomain() })
            } ?: run {
                return Result.failure(IOException("Missing results"))
            }
        } else {
            return Result.failure(IOException("Request is not successful"))
        }
    }

    override suspend fun getUpcomingMovies(): Result<List<MovieUpcoming>> {
        val response = movieApi.upcomingMovies("d9ae4921794c06bd0fdbd1463d274804", "1", "en-US")
        if (response.isSuccessful) {
            response.body()?.results?.let { list ->
                return Result.success(list.map { it.toDomain() })
            } ?: run {
                return Result.failure(IOException("Missing results"))
            }
        } else {
            return Result.failure(IOException("Request is not successful"))
        }
    }
}