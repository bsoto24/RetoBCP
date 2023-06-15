package pe.com.test.data.mapper

import pe.com.test.data.datasource.remote.response.MoviePopularResponse
import pe.com.test.data.datasource.remote.response.MovieUpcomingResponse
import pe.com.test.data.entity.MoviePopular
import pe.com.test.data.entity.MovieUpcoming


/**
 * MovieMapper
 *
 * @author Bryam Soto
 * @since 15/06/23
 */

fun MoviePopularResponse.toDomain() = MoviePopular(
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

fun MovieUpcomingResponse.toDomain() = MovieUpcoming(
    popularity,
    voteCount,
    video,
    posterPath,
    id,
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