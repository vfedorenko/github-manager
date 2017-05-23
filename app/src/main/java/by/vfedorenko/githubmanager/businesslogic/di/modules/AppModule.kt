package by.vfedorenko.githubmanager.businesslogic.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
@dagger.Module
class AppModule(private val context: android.content.Context) {
    companion object {
        private const val PREFS_KEY = "prefs_storage_file"
    }

    @javax.inject.Singleton
    @dagger.Provides
    fun provideApplication() = context

    @javax.inject.Singleton
    @dagger.Provides
    fun provideSharedPreferences(): android.content.SharedPreferences = context.getSharedPreferences(by.vfedorenko.githubmanager.businesslogic.di.modules.AppModule.Companion.PREFS_KEY, android.content.Context.MODE_PRIVATE)
}
