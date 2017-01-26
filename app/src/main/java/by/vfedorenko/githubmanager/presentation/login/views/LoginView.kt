package by.vfedorenko.githubmanager.presentation.login.views

import android.content.Context
import rx.Single

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
interface LoginView {
    fun beginLogin(): Single<String>
    fun getContext(): Context
}
