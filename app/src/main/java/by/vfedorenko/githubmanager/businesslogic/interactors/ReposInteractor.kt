package by.vfedorenko.githubmanager.businesslogic.interactors

import by.vfedorenko.githubmanager.businesslogic.network.ReposApi
import by.vfedorenko.githubmanager.entities.plain.Repo
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
@Singleton
class ReposInteractor
@Inject constructor(private val reposApi: ReposApi) {
    fun getRepos(): Single<List<Repo>> = reposApi.getRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
