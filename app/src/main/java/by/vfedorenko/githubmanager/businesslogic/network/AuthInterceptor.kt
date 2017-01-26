package by.vfedorenko.githubmanager.businesslogic.network

import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
class AuthInterceptor(val authUserManager: AuthUserManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val requestBuilder = original.newBuilder()
        val token = authUserManager.getToken()
        if (token.isNotEmpty()) {
            requestBuilder.header("Authorization", "token $token")
        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
