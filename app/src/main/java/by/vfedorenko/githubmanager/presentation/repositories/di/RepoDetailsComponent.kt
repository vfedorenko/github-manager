package by.vfedorenko.githubmanager.presentation.repositories.di

import by.vfedorenko.githubmanager.presentation.di.ActivityModule
import by.vfedorenko.githubmanager.presentation.di.scopes.RepoDetailsScope
import by.vfedorenko.githubmanager.presentation.repositories.RepoDetailsActivity
import dagger.Subcomponent

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.02.17.
 */
@RepoDetailsScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface RepoDetailsComponent {
    fun inject(activity: RepoDetailsActivity)
}
