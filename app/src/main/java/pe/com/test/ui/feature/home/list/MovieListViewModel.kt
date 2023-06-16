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

    fun getPopularMovies() {
        if (popularMovies.value.isNullOrEmpty()) {
            viewModelScope.launch {
                moviePopularUC()
                    .onSuccess {
                        _popularMovies.value = it
                    }
                    .onFailure {
                        _error.value = R.string.errorSearch
                    }
            }
        }
    }

    fun getUpcomingMovies() {
        if (upcomingMovies.value.isNullOrEmpty()) {
            viewModelScope.launch {
                movieUpcomingUC()
                    .onSuccess {
                        _upcomingMovies.value = it
                    }.onFailure {
                        _error.value = R.string.errorSearch
                    }
            }
        }
    }

}