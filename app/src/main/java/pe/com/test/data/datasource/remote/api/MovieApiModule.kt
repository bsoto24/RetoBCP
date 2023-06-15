package pe.com.test.data.datasource.remote.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


/**
 * ApiModule
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
@Module
@InstallIn(SingletonComponent::class)
class MovieApiModule {

    @Provides
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

}