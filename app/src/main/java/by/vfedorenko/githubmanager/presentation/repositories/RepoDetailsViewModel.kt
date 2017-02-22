package by.vfedorenko.githubmanager.presentation.repositories

import by.vfedorenko.githubmanager.presentation.App
import by.vfedorenko.githubmanager.presentation.di.scopes.RepoScope
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.02.17.
 */
@RepoScope
class RepoDetailsViewModel @Inject constructor() {
    var someTitle = App.EMPTY_STRING

    fun setTitle(title: String) {
        someTitle = title
    }

    fun getTitle() = someTitle
}
