package by.vfedorenko.githubmanager.businesslogic.di

import android.support.v7.app.AppCompatActivity
import by.vfedorenko.githubmanager.presentation.di.ActivityModule
import by.vfedorenko.githubmanager.presentation.di.AppComponent
import by.vfedorenko.githubmanager.presentation.login.LoginActivity
import by.vfedorenko.githubmanager.presentation.login.di.LoginComponent
import by.vfedorenko.githubmanager.presentation.repositories.RepoDetailsActivity
import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity
import by.vfedorenko.githubmanager.presentation.repositories.di.RepoDetailsComponent
import by.vfedorenko.githubmanager.presentation.repositories.di.ReposComponent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.02.17.
 */
@Singleton
class ComponentsManager @Inject constructor(private val appComponent: AppComponent) {
    private var loginComponent: LoginComponent? = null
    private var reposComponent: ReposComponent? = null
    private var repoDetailsComponent: RepoDetailsComponent? = null

    fun injectMe(activity: AppCompatActivity) {
        when (activity) {
            is LoginActivity -> obtainLoginComponent(activity).inject(activity)
            is ReposActivity -> obtainReposComponent(activity).inject(activity)
            is RepoDetailsActivity -> obtainRepoDetailsComponent(activity).inject(activity)
            else -> throw IllegalArgumentException("Cannot find component for your activity $activity")
        }
    }

    fun clearLoginScope() {
        loginComponent = null
    }

    fun clearReposScope() {
        reposComponent = null
    }

    fun clearRepoDetailsScope() {
        repoDetailsComponent = null
    }

    private fun obtainLoginComponent(activity: AppCompatActivity): LoginComponent {
        if (loginComponent == null) {
            loginComponent = appComponent.loginComponent(ActivityModule(activity))
        }

        return loginComponent ?: throw IllegalStateException("Component was set to null by another thread")
    }

    private fun obtainReposComponent(activity: AppCompatActivity): ReposComponent {
        if (reposComponent == null) {
            reposComponent = appComponent.reposComponent(ActivityModule(activity))
        }

        return reposComponent ?: throw IllegalStateException("Component was set to null by another thread")
    }

    private fun obtainRepoDetailsComponent(activity: AppCompatActivity): RepoDetailsComponent {
        if (repoDetailsComponent == null) {
            repoDetailsComponent = appComponent.repoDetailsComponent(ActivityModule(activity))
        }

        return repoDetailsComponent ?: throw IllegalStateException("Component was set to null by another thread")
    }
}
