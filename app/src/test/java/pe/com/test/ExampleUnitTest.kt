package pe.com.test

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import pe.com.test.domain.movie.entity.Movie
import pe.com.test.ui.util.notReleasedYet
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun `the movie is not released yet`() {
        val movie = Movie(
            popularity = 7.8,
            video = false,
            voteCount = 1000,
            id = 123,
            posterPath = "/example_poster.jpg",
            adult = false,
            backdropPath = "/example_backdrop.jpg",
            originalLanguage = "en",
            originalTitle = "Example Movie",
            genreIds = listOf(1, 2, 3),
            title = "Example Movie",
            voteAverage = 7.5,
            overview = "This is an example movie",
            releaseDate = "2023-07-01"
        )
        Instant.now(
            Clock.fixed(
                Instant.parse("2023-06-15T10:00:00Z"),
                ZoneOffset.UTC
            )
        )
        val result = notReleasedYet(movie.releaseDate)
        assertTrue(result)
    }

    @Test
    fun `the movie is already released`() {
        val movie = Movie(
            popularity = 7.8,
            video = false,
            voteCount = 1000,
            id = 123,
            posterPath = "/example_poster.jpg",
            adult = false,
            backdropPath = "/example_backdrop.jpg",
            originalLanguage = "en",
            originalTitle = "Example Movie",
            genreIds = listOf(1, 2, 3),
            title = "Example Movie",
            voteAverage = 7.5,
            overview = "This is an example movie",
            releaseDate = "2022-04-01"
        )
        Instant.now(
            Clock.fixed(
                Instant.parse("2023-06-15T10:00:00Z"),
                ZoneOffset.UTC
            )
        )
        val result = notReleasedYet(movie.releaseDate)
        assertFalse(result)
    }

}