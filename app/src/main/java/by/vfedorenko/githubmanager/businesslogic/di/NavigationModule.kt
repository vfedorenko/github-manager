package by.vfedorenko.githubmanager.businesslogic.di

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
@Module
class NavigationModule {
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    @Singleton
    @Provides
    fun provideRouter() = cicerone.router

    @Singleton
    @Provides
    fun provideNavigationHolder() = cicerone.navigatorHolder
}
