package pe.com.test.data.datasource.remote.api

import pe.com.test.data.datasource.remote.entity.MoviePopularBase
import pe.com.test.data.datasource.remote.entity.MovieUpcomingBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * ApiInterface
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
interface MovieApi {

    @GET("3/movie/popular")
    suspend fun popularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: String,
        @Query("language") language: String
    ): Response<MoviePopularBase>

    @GET("3/movie/upcoming")
    suspend fun upcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: String,
        @Query("language") language: String
    ): Response<MovieUpcomingBase>
}