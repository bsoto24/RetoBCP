package pe.com.test.ui.feature.home.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.com.test.R
import pe.com.test.data.entity.MoviePopular
import pe.com.test.data.entity.MovieUpcoming
import pe.com.test.data.repository.MovieRepository
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<MoviePopular?>>()
    val popularMovies: LiveData<List<MoviePopular?>>
        get() = _popularMovies

    private val _upcomingMovies = MutableLiveData<List<MovieUpcoming?>>()
    val upcomingMovies: LiveData<List<MovieUpcoming?>>
        get() = _upcomingMovies

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int>
        get() = _error

    fun getPopularMovies() {
        if (popularMovies.value.isNullOrEmpty()) {
            viewModelScope.launch {
                movieRepository.getPopularMovies()
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
                movieRepository.getUpcomingMovies()
                    .onSuccess {
                        _upcomingMovies.value = it
                    }.onFailure {
                        _error.value = R.string.errorSearch
                    }
            }
        }
    }

}