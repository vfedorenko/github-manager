package by.vfedorenko.githubmanager.businesslogic.di.modules

import by.vfedorenko.githubmanager.businesslogic.data.RealmRepoRepository
import by.vfedorenko.githubmanager.businesslogic.data.RepoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.05.17.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRepoRepository(): RepoRepository = RealmRepoRepository()
}
