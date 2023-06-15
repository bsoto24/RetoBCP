package pe.com.test.ui.feature.home.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.com.test.R
import pe.com.test.data.datasource.remote.api.MovieApi
import pe.com.test.data.datasource.remote.entity.MoviePopular
import pe.com.test.data.datasource.remote.entity.MovieUpcoming
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieApi: MovieApi
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
                val response =
                    movieApi.popularMovies("d9ae4921794c06bd0fdbd1463d274804", "1", "en-US")
                if (response.isSuccessful) {
                    response.body()?.results?.let {
                        _popularMovies.value = it
                    } ?: run {
                        _error.value = R.string.errorSearch
                    }
                } else {
                    _error.value = R.string.errorSearch
                }
            }
        }
    }

    fun getUpcomingMovies() {
        if (upcomingMovies.value.isNullOrEmpty()) {
            viewModelScope.launch {
                val response =
                    movieApi.upcomingMovies("d9ae4921794c06bd0fdbd1463d274804", "1", "en-US")
                if (response.isSuccessful) {
                    response.body()?.results?.let {
                        _upcomingMovies.value = it
                    } ?: run {
                        _error.value = R.string.errorSearch
                    }
                } else {
                    _error.value = R.string.errorSearch
                }
            }
        }
    }

}