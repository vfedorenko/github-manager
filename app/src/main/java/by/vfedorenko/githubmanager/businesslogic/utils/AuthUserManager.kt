package by.vfedorenko.githubmanager.businesslogic.utils

import android.content.SharedPreferences
import by.vfedorenko.githubmanager.presentation.App
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
class AuthUserManager
@Inject constructor(val prefs: SharedPreferences) {
    companion object {
        private const val TOKEN = "token"
    }

    fun saveToken(token: String) {
        prefs.edit()
                .putString(TOKEN, token)
                .apply()
    }

    fun getToken() = prefs.getString(TOKEN, App.EMPTY_STRING)
}
