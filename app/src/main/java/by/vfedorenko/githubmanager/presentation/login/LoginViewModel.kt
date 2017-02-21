package by.vfedorenko.githubmanager.presentation.login

import android.util.Log
import by.vfedorenko.githubmanager.businesslogic.interactors.LoginInteractor
import by.vfedorenko.githubmanager.businesslogic.utils.NavigationManager
import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.01.17.
 */
class LoginViewModel @Inject constructor(val loginInteractor: LoginInteractor, val navigationManager: NavigationManager) {
    fun init(oAuthWebView: OAuthWebView) {
        oAuthWebView.beginLogin()
                .flatMap { loginInteractor.login(it) }
                .subscribe(
                        {
                            navigationManager.startActivity(ReposActivity.createIntent(navigationManager.activity))
                            navigationManager.finishActivity()
                        },
                        { Log.e("111", "error", it) }
                )
    }
}
