package by.vfedorenko.githubmanager.businesslogic.assemblies

import by.vfedorenko.githubmanager.businesslogic.interactors.LoginInteractor
import by.vfedorenko.githubmanager.businesslogic.network.LoginApi
import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
@Module
class InteractorsModule {
    @Singleton
    @Provides
    fun provideLoginInteractor(loginApi: LoginApi, authUserManager: AuthUserManager) =
            LoginInteractor(loginApi, authUserManager)
}
