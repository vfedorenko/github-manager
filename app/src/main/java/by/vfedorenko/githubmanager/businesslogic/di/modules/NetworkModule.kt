package by.vfedorenko.githubmanager.businesslogic.di.modules

import by.vfedorenko.githubmanager.businesslogic.network.AuthInterceptor
import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.01.17.
 */
@dagger.Module
class NetworkModule {

    @javax.inject.Singleton
    @dagger.Provides
    fun provideRetrofit(endpoint: String,
                        client: okhttp3.OkHttpClient,
                        converterFactory: retrofit2.Converter.Factory,
                        adapterFactory: retrofit2.CallAdapter.Factory) =
            retrofit2.Retrofit.Builder()
                    .baseUrl(endpoint)
                    .client(client)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(adapterFactory)
                    .build()

    @javax.inject.Singleton
    @dagger.Provides
    fun provideClient(interceptor: by.vfedorenko.githubmanager.businesslogic.network.AuthInterceptor) =
            okhttp3.OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

    @javax.inject.Singleton
    @dagger.Provides
    fun provideAuthInterceptor(authManager: by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager) = by.vfedorenko.githubmanager.businesslogic.network.AuthInterceptor(authManager)

    @javax.inject.Singleton
    @dagger.Provides
    fun provideConverterFactory(): retrofit2.Converter.Factory = retrofit2.converter.gson.GsonConverterFactory.create()

    @javax.inject.Singleton
    @dagger.Provides
    fun provideCallAdapterFactory(): retrofit2.CallAdapter.Factory = retrofit2.adapter.rxjava.RxJavaCallAdapterFactory.create()

    @javax.inject.Singleton
    @dagger.Provides
    fun provideApiEndpointUrl() = "https://github.com/"
}
