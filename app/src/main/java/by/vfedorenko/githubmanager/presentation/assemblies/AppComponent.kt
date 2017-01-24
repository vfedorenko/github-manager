package by.vfedorenko.githubmanager.presentation.assemblies

import by.vfedorenko.githubmanager.presentation.login.assemblies.LoginComponent
import dagger.Component
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun plus(): LoginComponent
}
