package by.vfedorenko.githubmanager.presentation.login.viewmodels

import android.util.Log
import by.vfedorenko.githubmanager.presentation.login.views.LoginView
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.01.17.
 */
class LoginViewModel @Inject constructor() {
    var loginView: LoginView? = null

    fun init() {
        loginView?.beginLogin()
                ?.subscribe(
                        { Log.d("111", "logged in $it")},
                        { Log.e("111", "error $it") }
                )
    }


}
