package by.vfedorenko.githubmanager.presentation.repositories

import android.view.View
import by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import by.vfedorenko.githubmanager.presentation.Activities
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
* @author Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
*/
@ActivityScope
class ReposViewModel
@Inject
constructor(authUserManager: AuthUserManager, private val router: Router) {

    init {
        if (authUserManager.getToken().isEmpty()) {
            router.replaceScreen(Activities.ACTIVITY_LOGIN)
        }
    }

    fun onRepoClick(v: View) {
        router.navigateTo(Activities.ACTIVITY_REPO_DETAILS)
    }
}
