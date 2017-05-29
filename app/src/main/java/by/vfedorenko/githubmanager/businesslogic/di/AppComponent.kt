package by.vfedorenko.githubmanager.businesslogic.di

import by.vfedorenko.githubmanager.businesslogic.di.modules.*
import by.vfedorenko.githubmanager.presentation.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        DataModule::class,
        NetworkModule::class,
        ApiModule::class,
        ActivityModule::class,
        NavigationModule::class))
interface AppComponent {
    fun inject(app: App)
}
