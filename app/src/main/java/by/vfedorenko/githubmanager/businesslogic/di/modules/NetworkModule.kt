package by.vfedorenko.githubmanager.businesslogic.di.modules

import by.vfedorenko.githubmanager.businesslogic.di.annotations.Api
import by.vfedorenko.githubmanager.businesslogic.di.annotations.Auth
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
@Module
class NetworkModule {

    @Singleton
    @Provides
    @Auth
    fun provideAuthRetrofit(@Auth endpoint: String,
                        client: OkHttpClient,
                        converterFactory: Converter.Factory,
                        adapterFactory: CallAdapter.Factory) =
            Retrofit.Builder()
                    .baseUrl(endpoint)
                    .client(client)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(adapterFactory)
                    .build()

    @Singleton
    @Provides
    @Api
    fun provideApiRetrofit(@Api endpoint: String,
                        client: OkHttpClient,
                        converterFactory: Converter.Factory,
                        adapterFactory: CallAdapter.Factory) =
            Retrofit.Builder()
                    .baseUrl(endpoint)
                    .client(client)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(adapterFactory)
                    .build()

    @Singleton
    @Provides
    fun provideClient(interceptor: AuthInterceptor) =
            OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

    @Singleton
    @Provides
    fun provideAuthInterceptor(authManager: AuthUserManager) = AuthInterceptor(authManager)

    @Singleton
    @Provides
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJavaCallAdapterFactory.create()

    @Singleton
    @Provides
    @Auth
    fun provideAuthUrl() = "https://github.com/"

    @Singleton
    @Provides
    @Api
    fun provideApiUrl() = "https://api.github.com/"
}
