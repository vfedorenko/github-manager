package by.vfedorenko.githubmanager.presentation.login.di

import by.vfedorenko.githubmanager.presentation.di.scopes.LoginScope
import by.vfedorenko.githubmanager.presentation.login.LoginActivity
import dagger.Subcomponent

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@LoginScope
@Subcomponent()
interface LoginComponent {
    fun inject(activity: LoginActivity)
}
