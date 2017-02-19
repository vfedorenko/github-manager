package by.vfedorenko.githubmanager.presentation

import android.app.Application
import android.support.v7.app.AppCompatActivity
import by.vfedorenko.githubmanager.presentation.assemblies.ActivityModule
import by.vfedorenko.githubmanager.presentation.assemblies.AppComponent
import by.vfedorenko.githubmanager.presentation.assemblies.AppModule
import by.vfedorenko.githubmanager.presentation.assemblies.DaggerAppComponent
import by.vfedorenko.githubmanager.presentation.login.activities.LoginActivity
import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity

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


    fun injectMe(activity: AppCompatActivity) {
        when (activity) {
            is LoginActivity -> appComponent.plus(ActivityModule(activity)).inject(activity)
            is ReposActivity -> appComponent.plus().inject(activity)
        }
    }
}
