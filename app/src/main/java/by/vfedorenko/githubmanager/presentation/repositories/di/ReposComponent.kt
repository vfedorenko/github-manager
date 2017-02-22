package by.vfedorenko.githubmanager.presentation.repositories.di

import by.vfedorenko.githubmanager.presentation.di.ActivityModule
import by.vfedorenko.githubmanager.presentation.di.scopes.RepoScope
import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity
import dagger.Subcomponent

/**
* @author Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
*/
@RepoScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ReposComponent {
    fun inject(activity: ReposActivity)
}
