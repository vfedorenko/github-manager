package by.vfedorenko.githubmanager.presentation.repositories.viewmodels

import by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
import by.vfedorenko.githubmanager.businesslogic.interactors.ReposInteractor
import by.vfedorenko.githubmanager.presentation.App
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.02.17.
 */
@ActivityScope
class RepoDetailsViewModel @Inject constructor(private val router: Router,
                                               private val reposInteractor: ReposInteractor) {

    var someTitle = App.EMPTY_STRING

    fun init(repoId: Long) {
        someTitle = repoId.toString()
    }

    fun setTitle(title: String) {
        someTitle = title
    }

    fun getTitle() = someTitle
}
