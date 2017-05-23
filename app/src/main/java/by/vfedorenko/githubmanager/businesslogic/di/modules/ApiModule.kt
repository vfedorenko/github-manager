package by.vfedorenko.githubmanager.businesslogic.di.modules

import by.vfedorenko.githubmanager.businesslogic.network.LoginApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideLoginApi(retrofit: Retrofit) = retrofit.create(LoginApi::class.java)
}
