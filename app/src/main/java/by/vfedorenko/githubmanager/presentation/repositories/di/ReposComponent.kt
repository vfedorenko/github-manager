package by.vfedorenko.githubmanager.presentation.repositories.di

import by.vfedorenko.githubmanager.presentation.di.scopes.RepoScope
import by.vfedorenko.githubmanager.presentation.repositories.RepoDetailsActivity
import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity
import dagger.Subcomponent

/**
* @author Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
*/
@RepoScope
@Subcomponent()
interface ReposComponent {
    fun inject(activity: ReposActivity)
    fun inject(activity: RepoDetailsActivity)
}
