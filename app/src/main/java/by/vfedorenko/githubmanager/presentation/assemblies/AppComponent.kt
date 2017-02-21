package by.vfedorenko.githubmanager.presentation.assemblies

import by.vfedorenko.githubmanager.businesslogic.assemblies.ApiModule
import by.vfedorenko.githubmanager.businesslogic.assemblies.InteractorsModule
import by.vfedorenko.githubmanager.businesslogic.assemblies.NetworkModule
import by.vfedorenko.githubmanager.businesslogic.assemblies.UtilsModule
import by.vfedorenko.githubmanager.presentation.login.LoginComponent
import by.vfedorenko.githubmanager.presentation.repositories.ReposComponent
import dagger.Component
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class, UtilsModule::class, InteractorsModule::class))
interface AppComponent {
    fun plus(activityModule: ActivityModule): LoginComponent
    fun plus(): ReposComponent
}
