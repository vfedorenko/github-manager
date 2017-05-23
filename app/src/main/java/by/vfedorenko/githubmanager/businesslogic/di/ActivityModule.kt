package by.vfedorenko.githubmanager.businesslogic.di

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
@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeBaseActivityInjector(): BaseActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeLoginActivityInjector(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeReposActivityInjector(): ReposActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeRepoDetailsActivityInjector(): RepoDetailsActivity
}
