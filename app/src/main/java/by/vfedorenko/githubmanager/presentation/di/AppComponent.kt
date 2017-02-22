package by.vfedorenko.githubmanager.presentation.di

import by.vfedorenko.githubmanager.businesslogic.di.ApiModule
import by.vfedorenko.githubmanager.businesslogic.di.ComponentsManager
import by.vfedorenko.githubmanager.businesslogic.di.NetworkModule
import by.vfedorenko.githubmanager.presentation.login.di.LoginComponent
import by.vfedorenko.githubmanager.presentation.repositories.di.RepoDetailsComponent
import by.vfedorenko.githubmanager.presentation.repositories.di.ReposComponent
import dagger.Component
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class))
interface AppComponent {
    fun componentsManager(): ComponentsManager

    fun loginComponent(activityModule: ActivityModule): LoginComponent
    fun reposComponent(activityModule: ActivityModule): ReposComponent
    fun repoDetailsComponent(activityModule: ActivityModule): RepoDetailsComponent
}
