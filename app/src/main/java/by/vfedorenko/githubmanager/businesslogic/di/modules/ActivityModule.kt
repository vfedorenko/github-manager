package by.vfedorenko.githubmanager.businesslogic.di.modules

import by.vfedorenko.githubmanager.presentation.repositories.activities.RepoDetailsActivity
import by.vfedorenko.githubmanager.presentation.repositories.activities.ReposActivity

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
    abstract fun contributeReposActivityInjector(): ReposActivity

    @by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
    @dagger.android.ContributesAndroidInjector
    abstract fun contributeRepoDetailsActivityInjector(): RepoDetailsActivity
}
