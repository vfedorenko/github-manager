package by.vfedorenko.githubmanager.businesslogic.di.modules

import by.vfedorenko.githubmanager.businesslogic.di.annotations.Api
import by.vfedorenko.githubmanager.businesslogic.di.annotations.Auth
import by.vfedorenko.githubmanager.businesslogic.network.LoginApi
import by.vfedorenko.githubmanager.businesslogic.network.ReposApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
* @author Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
*/
@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideLoginApi(@Auth retrofit: Retrofit) = retrofit.create(LoginApi::class.java)

    @Singleton
    @Provides
    fun provideReposApi(@Api retrofit: Retrofit) = retrofit.create(ReposApi::class.java)
}
