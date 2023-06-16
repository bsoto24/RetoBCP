package pe.com.test.data.datasource.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MoviePopularBaseResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<MoviePopularResponse>
)