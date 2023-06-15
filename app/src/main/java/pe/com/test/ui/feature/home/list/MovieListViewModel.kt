package pe.com.test.ui.feature.home.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.com.test.R
import pe.com.test.data.datasource.remote.api.ApiManager
import pe.com.test.data.datasource.remote.entity.MoviePopular
import pe.com.test.data.datasource.remote.entity.MovieUpcoming
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(): ViewModel() {

    val data = MutableLiveData<List<MoviePopular?>>()
    val movieUpcoming = MutableLiveData<List<MovieUpcoming?>>()
    val error = MutableLiveData<Int>()

    fun data() {

        viewModelScope.launch {
            val response =
                ApiManager.get().popularMovies("d9ae4921794c06bd0fdbd1463d274804", "1", "en-US")
            if (response.isSuccessful) {
                data.value = response.body()!!.results
            } else {
                error.value = R.string.errorSearch
            }

            val movieUpcomingResponse = ApiManager.get()
                .upcomingMovies("d9ae4921794c06bd0fdbd1463d274804", "1", "en-US")
            if (response.isSuccessful) {
                movieUpcoming.value = movieUpcomingResponse.body()!!.results
            } else {
                error.value = R.string.errorSearch
            }
        }
    }

}