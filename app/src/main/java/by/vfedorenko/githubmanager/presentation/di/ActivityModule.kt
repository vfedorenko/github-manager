package by.vfedorenko.githubmanager.presentation.di

import android.support.v7.app.AppCompatActivity
import by.vfedorenko.githubmanager.businesslogic.utils.NavigationManager
import dagger.Module
import dagger.Provides

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 22.02.17.
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {
    @Provides
    fun provideNavigationManager() = NavigationManager(activity)
}
