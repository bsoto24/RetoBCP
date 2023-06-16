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
    popularity,
    video,
    voteCount,
    id,
    posterPath,
    adult,
    backdropPath,
    originalLanguage,
    originalTitle,
    genreIds,
    title,
    voteAverage,
    overview,
    releaseDate
)

fun MovieUpcomingResponse.toDomain() = Movie(
    popularity,
    video,
    voteCount,
    id,
    posterPath,
    adult,
    backdropPath,
    originalLanguage,
    originalTitle,
    genreIds,
    title,
    voteAverage,
    overview,
    releaseDate
)