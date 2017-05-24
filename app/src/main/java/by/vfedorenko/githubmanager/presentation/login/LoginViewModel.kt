package by.vfedorenko.githubmanager.presentation.login

import by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
import by.vfedorenko.githubmanager.businesslogic.interactors.LoginInteractor
import by.vfedorenko.githubmanager.presentation.ACTIVITY_REPOS
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.01.17.
 */
@ActivityScope
class LoginViewModel
@Inject
constructor(private val loginInteractor: LoginInteractor,
            private val router: Router) {

    fun init(oAuthWebView: OAuthWebView) {
        oAuthWebView.beginLogin()
                .flatMap { loginInteractor.login(it) }
                .subscribe(
                        { router.replaceScreen(ACTIVITY_REPOS) },
                        { Timber.e(it) }
                )
    }
}
