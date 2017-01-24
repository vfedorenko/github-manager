package by.vfedorenko.githubmanager.presentation.login.views

import rx.Observable

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
interface LoginView {
    fun beginLogin(): Observable<String>
}
