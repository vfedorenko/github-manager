package by.vfedorenko.githubmanager.presentation.repositories.viewmodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
import by.vfedorenko.githubmanager.businesslogic.interactors.ReposInteractor
import by.vfedorenko.githubmanager.entities.plain.Repo
import by.vfedorenko.githubmanager.presentation.App
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.02.17.
 */
@ActivityScope
class RepoDetailsViewModel @Inject constructor(
        private val router: Router,
        private val reposInteractor: ReposInteractor
) : BaseObservable() {
    var repo = Repo()

    fun init(repoId: Long) {
        reposInteractor.getRepo(repoId)
                .subscribe({
                    repo = it
                    notifyChange()

                }, { Timber.e(it) })
    }

    @Bindable
    fun getRepoName() = repo.name

    @Bindable
    fun getDescription() = repo.description ?: App.EMPTY_STRING

    @Bindable
    fun getLanguage() = repo.language ?: App.EMPTY_STRING

    @Bindable
    fun getForksCount() = repo.forksCount

    @Bindable
    fun getStarsCount() = repo.starsCount

    @Bindable
    fun getWatchersCount() = repo.watchersCount

    fun onBrowseCodeClick(v: View) {

    }
}
