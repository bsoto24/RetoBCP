package pe.com.test.data.datasource.remote.response

import com.google.gson.annotations.SerializedName

data class MovieUpcomingBaseResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<MovieUpcomingResponse>
)