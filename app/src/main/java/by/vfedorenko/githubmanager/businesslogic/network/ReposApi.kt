package by.vfedorenko.githubmanager.businesslogic.network

import by.vfedorenko.githubmanager.entities.plain.Repo
import retrofit2.http.GET
import rx.Observable

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
interface ReposApi {
    @GET("user/repos")
    fun getRepos(): Observable<List<Repo>>
}
