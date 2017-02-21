package by.vfedorenko.githubmanager.presentation.login

import by.vfedorenko.githubmanager.presentation.assemblies.ActivityModule
import by.vfedorenko.githubmanager.presentation.login.LoginActivity
import dagger.Subcomponent

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface LoginComponent {
    fun inject(activity: LoginActivity)
}
