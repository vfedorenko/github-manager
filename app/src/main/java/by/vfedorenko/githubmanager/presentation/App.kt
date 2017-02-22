package by.vfedorenko.githubmanager.presentation

import android.app.Application
import android.support.v7.app.AppCompatActivity
import by.vfedorenko.githubmanager.presentation.di.AppComponent
import by.vfedorenko.githubmanager.presentation.di.AppModule
import by.vfedorenko.githubmanager.presentation.di.DaggerAppComponent
import by.vfedorenko.githubmanager.presentation.login.LoginActivity
import by.vfedorenko.githubmanager.presentation.login.di.LoginComponent
import by.vfedorenko.githubmanager.presentation.repositories.RepoDetailsActivity
import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity
import by.vfedorenko.githubmanager.presentation.repositories.di.ReposComponent
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.01.17.
 */
class App : Application() {
    companion object {
        const val EMPTY_STRING = ""
        const val ZERO_DATE = 0L
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .build()
    }

//    val activityComponent: ActivityComponent by lazy {
//        appComponent.plus()
//    }

    val loginComponent: LoginComponent by lazy {
        appComponent.loginComponent()
    }

    val reposComponent: ReposComponent by lazy {
        appComponent.reposComponent()
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(DebugTree())
    }

    fun injectMe(activity: AppCompatActivity) {
        when (activity) {
            is LoginActivity -> loginComponent.inject(activity)
            is ReposActivity -> reposComponent.inject(activity)
            is RepoDetailsActivity -> reposComponent.inject(activity)
            else -> throw IllegalArgumentException("Cannot find component for given injection")
        }
    }
}
