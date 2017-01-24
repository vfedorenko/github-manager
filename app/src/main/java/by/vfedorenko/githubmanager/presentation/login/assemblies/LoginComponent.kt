package by.vfedorenko.githubmanager.presentation.login.assemblies

import by.vfedorenko.githubmanager.presentation.login.activities.LoginActivity
import dagger.Subcomponent

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@Subcomponent
interface LoginComponent {
    fun inject(activity: LoginActivity)
}
