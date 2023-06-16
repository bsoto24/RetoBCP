package pe.com.test.ui.feature.home.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.com.test.R
import pe.com.test.domain.movie.entity.Movie
import pe.com.test.domain.movie.usecase.MoviePopularUC
import pe.com.test.domain.movie.usecase.MovieUpcomingUC
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val moviePopularUC: MoviePopularUC,
    private val movieUpcomingUC: MovieUpcomingUC
) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<Movie?>>()
    val popularMovies: LiveData<List<Movie?>>
        get() = _popularMovies

    private val _upcomingMovies = MutableLiveData<List<Movie?>>()
    val upcomingMovies: LiveData<List<Movie?>>
        get() = _upcomingMovies

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int>
        get() = _error

    var popularMoviePager = MoviePager()
    var upcomingMoviePager = MoviePager()

    fun getPopularMovies(pagination: Boolean = false) {
        if (popularMovies.value.isNullOrEmpty() || pagination) {
            viewModelScope.launch {
                popularMoviePager.isLoading = true
                moviePopularUC(popularMoviePager.page)
                    .onSuccess {
                        val previousList = popularMovies.value ?: listOf()
                        val newList = previousList + it
                        popularMoviePager.page++
                        _popularMovies.value = newList
                        popularMoviePager.isLoading = false
                    }
                    .onFailure {
                        popularMoviePager.hasNext = true
                        popularMoviePager.isLoading = false
                        _error.value = R.string.errorSearch
                    }
            }
        }
    }

    fun getUpcomingMovies(pagination: Boolean = false) {
        if (upcomingMovies.value.isNullOrEmpty() || pagination) {
            viewModelScope.launch {
                upcomingMoviePager.isLoading = true
                movieUpcomingUC(upcomingMoviePager.page)
                    .onSuccess {
                        val previousList = upcomingMovies.value ?: listOf()
                        val newList = previousList + it
                        upcomingMoviePager.page++
                        _upcomingMovies.value = newList
                        upcomingMoviePager.isLoading = false
                    }.onFailure {
                        upcomingMoviePager.hasNext = true
                        upcomingMoviePager.isLoading = false
                        _error.value = R.string.errorSearch
                    }
            }
        }
    }

}