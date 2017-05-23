package by.vfedorenko.githubmanager.businesslogic.di.modules

import by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
import by.vfedorenko.githubmanager.presentation.BaseActivity
import by.vfedorenko.githubmanager.presentation.login.LoginActivity
import by.vfedorenko.githubmanager.presentation.repositories.RepoDetailsActivity
import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 19.05.17.
 */
@dagger.Module
abstract class ActivityModule {
    @by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
    @dagger.android.ContributesAndroidInjector
    abstract fun contributeBaseActivityInjector(): by.vfedorenko.githubmanager.presentation.BaseActivity

    @by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
    @dagger.android.ContributesAndroidInjector
    abstract fun contributeLoginActivityInjector(): by.vfedorenko.githubmanager.presentation.login.LoginActivity

    @by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
    @dagger.android.ContributesAndroidInjector
    abstract fun contributeReposActivityInjector(): by.vfedorenko.githubmanager.presentation.repositories.ReposActivity

    @by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
    @dagger.android.ContributesAndroidInjector
    abstract fun contributeRepoDetailsActivityInjector(): by.vfedorenko.githubmanager.presentation.repositories.RepoDetailsActivity
}
