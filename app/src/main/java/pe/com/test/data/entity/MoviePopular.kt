package pe.com.test.data.entity

data class MoviePopular(
    val popularity: Double,
    val video: Boolean,
    val voteCount: Int,
    val id: Int,
    val posterPath: String,
    val adult: Boolean,
    val backdropPath: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Int>,
    val title: String,
    val voteAverage: Double,
    val overview: String,
    val releaseDate: String
)
