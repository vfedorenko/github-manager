package by.vfedorenko.githubmanager.presentation

import android.app.Activity
import android.app.Application
import by.vfedorenko.githubmanager.businesslogic.di.DaggerAppComponent
import by.vfedorenko.githubmanager.businesslogic.di.modules.AppModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
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

        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build())
        Timber.plant(DebugTree())
    }

    override fun activityInjector() = dispatchingActivityInjector
}
