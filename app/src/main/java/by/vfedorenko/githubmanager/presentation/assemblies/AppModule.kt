package by.vfedorenko.githubmanager.presentation.assemblies

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
        val PREFS_KEY = "prefs_storage_file"
    }

    @Singleton
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
}
