package by.vfedorenko.githubmanager.businesslogic.interactors

import by.vfedorenko.githubmanager.businesslogic.data.RepoRepository
import by.vfedorenko.githubmanager.businesslogic.network.ReposApi
import by.vfedorenko.githubmanager.entities.plain.Repo
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
@Singleton
class ReposInteractor
@Inject constructor(private val reposApi: ReposApi, private val reposRepository: RepoRepository) {
    fun getRepos(withSync: Boolean): Observable<List<Repo>> {
        return synchRepos()
//        return Observable.concat(reposRepository.getRepos(), synchRepos())
        //.first { !withSync }
    }

    fun getRepo(id: Long) = reposRepository.getRepo(id)

    private fun synchRepos() = reposApi.getRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { reposRepository.updateRepos(it) }
}
