package by.vfedorenko.githubmanager.presentation.repositories

import android.view.View
import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import by.vfedorenko.githubmanager.businesslogic.utils.NavigationManager
import by.vfedorenko.githubmanager.presentation.di.scopes.RepoScope
import by.vfedorenko.githubmanager.presentation.login.LoginActivity
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
@RepoScope
class ReposViewModel @Inject constructor(authUserManager: AuthUserManager,
                                         private val navigationManager: NavigationManager) {

    init {
        if (authUserManager.getToken().isEmpty()) {
            navigationManager.startActivity(LoginActivity.createIntent(navigationManager.activity))
        }
    }

    fun onRepoClick(v: View) {
        navigationManager.startActivity(RepoDetailsActivity.createIntent(navigationManager.activity))
    }
}
