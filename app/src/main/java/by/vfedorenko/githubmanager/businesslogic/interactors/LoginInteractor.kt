package by.vfedorenko.githubmanager.businesslogic.interactors

import by.vfedorenko.githubmanager.businesslogic.network.HttpException
import by.vfedorenko.githubmanager.businesslogic.network.LoginApi
import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import by.vfedorenko.githubmanager.entities.network.AuthBody
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
class LoginInteractor
@Inject constructor(val loginApi: LoginApi, val authUserManager: AuthUserManager) {
    fun login(code: String): Single<Boolean> {
        return loginApi.getToken(AuthBody(code))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { response ->
                    if (response.isSuccessful) {
                        authUserManager.saveToken(response.body().token)
                        true
                    } else {
                        throw HttpException(response.errorBody().string(), response.code())
                    }
                }
    }
}