package by.vfedorenko.githubmanager.businesslogic.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@Module
class AppModule(private val context: Context) {
    companion object {
        private const val PREFS_KEY = "prefs_storage_file"
    }

    @Singleton
    @Provides
    fun provideApplication() = context

    @Singleton
    @Provides
    fun provideSharedPreferences(): SharedPreferences = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
}
