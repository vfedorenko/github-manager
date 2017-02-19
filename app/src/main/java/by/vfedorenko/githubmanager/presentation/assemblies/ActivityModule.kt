package by.vfedorenko.githubmanager.presentation.assemblies

import android.support.v7.app.AppCompatActivity
import by.vfedorenko.githubmanager.businesslogic.utils.NavigationManager
import dagger.Module
import dagger.Provides

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
@Module
class ActivityModule(val activity: AppCompatActivity) {
    @Provides
    fun provideNavigationManager() = NavigationManager(activity)
}
