package by.vfedorenko.githubmanager.presentation.repositories.viewmodels

import android.view.View
import by.vfedorenko.githubmanager.entities.plain.Repo
import by.vfedorenko.githubmanager.presentation.ACTIVITY_REPO_DETAILS
import by.vfedorenko.githubmanager.presentation.repositories.activities.RepoDetailsActivity
import ru.terrakok.cicerone.Router

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
class RepoItemViewModel(private val router: Router) {
    var repo = Repo()

    fun getOwnerName() = repo.owner.login

    fun getName() = repo.name

    fun getDescription() = repo.description

    fun getAvatarUrl() = repo.owner.avatar

    fun hasDescription() = !repo.description.isNullOrBlank()

    fun onItemClick(v: View) {
        val b = RepoDetailsActivity.buildBundle(repo.id)
        router.navigateTo(ACTIVITY_REPO_DETAILS, b)
    }
}
