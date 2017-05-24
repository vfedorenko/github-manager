package by.vfedorenko.githubmanager.presentation.repositories.viewmodels

import by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
import by.vfedorenko.githubmanager.businesslogic.interactors.ReposInteractor
import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import by.vfedorenko.githubmanager.presentation.ACTIVITY_LOGIN
import by.vfedorenko.githubmanager.presentation.repositories.ReposAdapter
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
@ActivityScope
class ReposViewModel
@Inject
constructor(authUserManager: AuthUserManager,
            private val router: Router,
            reposInteractor: ReposInteractor,
            val adapter: ReposAdapter) {

    init {
        if (authUserManager.getToken().isEmpty()) {
            router.replaceScreen(ACTIVITY_LOGIN)
        } else {
            reposInteractor.getRepos()
                    .subscribe(
                            {
                                adapter.refreshItems(it)
                            },
                            {
                                Timber.e(it)
                                router.showSystemMessage("Failed to load repos: ${it.message}")
                            })
        }
    }
}
