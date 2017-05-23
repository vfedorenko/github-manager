package by.vfedorenko.githubmanager.presentation

import android.app.Activity
import android.app.Application
import by.vfedorenko.githubmanager.businesslogic.di.AppModule
import by.vfedorenko.githubmanager.businesslogic.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject


/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.01.17.
 */
class App : Application(), HasActivityInjector {
    companion object {
        const val EMPTY_STRING = ""
        const val ZERO = 0L
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .build()
                .inject(this)

        Timber.plant(DebugTree())
    }

    override fun activityInjector() = dispatchingActivityInjector
}
