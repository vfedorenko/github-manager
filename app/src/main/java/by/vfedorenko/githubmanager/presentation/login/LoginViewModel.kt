package by.vfedorenko.githubmanager.presentation.login

import by.vfedorenko.githubmanager.businesslogic.interactors.LoginInteractor
import by.vfedorenko.githubmanager.presentation.di.scopes.LoginScope
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.01.17.
 */
@LoginScope
class LoginViewModel @Inject constructor(val loginInteractor: LoginInteractor) {
    fun init(oAuthWebView: OAuthWebView) {
        oAuthWebView.beginLogin()
                .flatMap { loginInteractor.login(it) }
                .subscribe(
                        {
//                            navigationManager.startActivityAndFinish(ReposActivity.createIntent(navigationManager.activity))
                        },
                        { Timber.e(it) }
                )
    }
}
