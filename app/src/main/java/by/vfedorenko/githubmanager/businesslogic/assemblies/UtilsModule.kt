package by.vfedorenko.githubmanager.businesslogic.assemblies

import android.content.SharedPreferences
import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
@Module
class UtilsModule {
    @Singleton
    @Provides
    fun provideAuthUserManager(prefs: SharedPreferences) = AuthUserManager(prefs)
}
