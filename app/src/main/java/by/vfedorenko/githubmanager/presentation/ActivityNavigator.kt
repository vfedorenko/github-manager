package by.vfedorenko.githubmanager.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import by.vfedorenko.githubmanager.presentation.login.LoginActivity
import by.vfedorenko.githubmanager.presentation.repositories.activities.RepoDetailsActivity
import by.vfedorenko.githubmanager.presentation.repositories.activities.ReposActivity
import by.vfedorenko.githubmanager.startActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.*
import java.lang.UnsupportedOperationException

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
class ActivityNavigator(private val activity: Activity) : Navigator {
    override fun applyCommand(command: Command) = when (command) {
        is Replace -> {
            startActivity(command.screenKey, command.transitionData as? Bundle ?: Bundle())
            activity.finish()
        }
        is Forward -> startActivity(command.screenKey, command.transitionData as? Bundle ?: Bundle())
        is Back -> activity.finish()
        is SystemMessage -> Toast.makeText(activity, command.message, Toast.LENGTH_LONG).show()
        else -> throw UnsupportedOperationException("$command is not supported")
    }

    private fun startActivity(screenKey: String, extras: Bundle) = when (screenKey) {
        ACTIVITY_LOGIN -> activity.startActivity<LoginActivity>(extras)
        ACTIVITY_REPOS -> activity.startActivity<ReposActivity>(extras)
        ACTIVITY_REPO_DETAILS -> activity.startActivity<RepoDetailsActivity>(extras)
        else -> throw UnsupportedOperationException("$screenKey is not supported")
    }
}
