package pe.com.test.data.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.com.test.data.datasource.MovieDS
import pe.com.test.data.datasource.MovieDSImpl
import pe.com.test.data.repository.MovieRepository
import pe.com.test.data.repository.MovieRepositoryImpl


/**
 * DatasourceModule
 *
 * @author Bryam Soto
 * @since 15/06/23
 */
@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

 @Binds
 abstract fun bindMovieRepository(repositoryImpl: MovieRepositoryImpl): MovieRepository


}