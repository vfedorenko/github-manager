package by.vfedorenko.githubmanager.businesslogic.data

import by.vfedorenko.githubmanager.entities.plain.Repo
import rx.Observable

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.05.17.
 */
interface RepoRepository {
    fun updateRepos(repos: List<Repo>)
    fun getRepos(): Observable<List<Repo>>
    fun getRepo(id: Long): Observable<Repo>
}
