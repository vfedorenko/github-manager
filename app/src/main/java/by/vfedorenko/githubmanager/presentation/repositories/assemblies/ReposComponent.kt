package by.vfedorenko.githubmanager.presentation.repositories.assemblies

import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity
import dagger.Subcomponent

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
@Subcomponent
interface ReposComponent {
    fun inject(activity: ReposActivity)
}
