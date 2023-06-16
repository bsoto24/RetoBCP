package pe.com.test.ui.feature.home.list


/**
 * MoviePager
 *
 * @author Bryam Soto
 * @since 16/06/23
 */
data class MoviePager(
    var page: Int = 1,
    var isLoading: Boolean = false,
    var hasNext: Boolean = true
)
