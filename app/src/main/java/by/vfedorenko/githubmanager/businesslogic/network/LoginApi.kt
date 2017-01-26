package by.vfedorenko.githubmanager.businesslogic.network

import by.vfedorenko.githubmanager.entities.network.AuthBody
import by.vfedorenko.githubmanager.entities.network.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Single

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.01.17.
 */
interface LoginApi {
    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    fun getToken(@Body body: AuthBody): Single<Response<TokenResponse>>
}
