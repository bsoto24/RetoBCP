package pe.com.test.domain.movie.mapper

import pe.com.test.data.datasource.remote.response.MoviePopularResponse
import pe.com.test.data.datasource.remote.response.MovieUpcomingResponse
import pe.com.test.domain.movie.entity.Movie


/**
 * MovieMapper
 *
 * @author Bryam Soto
 * @since 15/06/23
 */

fun MoviePopularResponse.toDomain() = Movie(
    popularity ?: 0.0,
    video ?: false,
    voteCount ?: 0,
    id ?: 0,
    posterPath ?: "",
    adult ?: false,
    backdropPath ?: "",
    originalLanguage ?: "",
    originalTitle ?: "",
    genreIds ?: listOf(),
    title ?: "",
    voteAverage ?: 0.0,
    overview ?: "",
    releaseDate ?: ""
)

fun MovieUpcomingResponse.toDomain() = Movie(
    popularity ?: 0.0,
    video ?: false,
    voteCount ?: 0,
    id ?: 0,
    posterPath ?: "",
    adult ?: false,
    backdropPath ?: "",
    originalLanguage ?: "",
    originalTitle ?: "",
    genreIds ?: listOf(),
    title ?: "",
    voteAverage ?: 0.0,
    overview ?: "",
    releaseDate ?: ""
)