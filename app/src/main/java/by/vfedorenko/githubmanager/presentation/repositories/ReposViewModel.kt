package by.vfedorenko.githubmanager.presentation.repositories

import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import by.vfedorenko.githubmanager.presentation.di.scopes.RepoScope
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
@RepoScope
class ReposViewModel @Inject constructor(authUserManager: AuthUserManager) {

    init {
        if (authUserManager.getToken().isEmpty()) {
            //navigationManager.startActivity(LoginActivity.createIntent(navigationManager.activity))
        }
    }

}
