package by.vfedorenko.githubmanager.presentation

import android.app.Application
import by.vfedorenko.githubmanager.businesslogic.di.ComponentsManager
import by.vfedorenko.githubmanager.presentation.di.AppModule
import by.vfedorenko.githubmanager.presentation.di.DaggerAppComponent
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

    val componentsManager: ComponentsManager by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .build()
                .componentsManager()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}
