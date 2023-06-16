package pe.com.test.data.datasource.remote.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException


/**
 * NetworkUtils
 *
 * @author Bryam Soto
 * @since 15/06/23
 */

suspend fun <T : Any> parseApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): Result<T> {

    return withContext(dispatcher) {
        try {
            val result = apiCall()
            if (result.isSuccessful) {
                result.body()?.let {
                    Result.success(it)
                } ?: run {
                    Result.failure(IOException("Empty body"))
                }
            } else {
                Result.failure(IOException("Request failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}