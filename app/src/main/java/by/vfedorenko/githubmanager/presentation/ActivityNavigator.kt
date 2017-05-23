package by.vfedorenko.githubmanager.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import by.vfedorenko.githubmanager.presentation.login.LoginActivity
import by.vfedorenko.githubmanager.presentation.repositories.RepoDetailsActivity
import by.vfedorenko.githubmanager.presentation.repositories.ReposActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import ru.terrakok.cicerone.commands.Replace
import java.lang.UnsupportedOperationException

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
class ActivityNavigator(private val activity: Activity) : Navigator {
    override fun applyCommand(command: Command) = when (command) {
        is Replace -> {
            activity.startActivity(createIntent(command.screenKey))
            activity.finish()
        }
        is Forward -> activity.startActivity(createIntent(command.screenKey))
        is Back -> activity.finish()
        else -> throw UnsupportedOperationException("$command is not supported")
    }

    private fun createIntent(screenKey: String) = when (screenKey) {
        Activities.ACTIVITY_LOGIN -> buildIntent(LoginActivity::class.java, BaseActivity.createBundle())
        Activities.ACTIVITY_REPOS -> buildIntent(ReposActivity::class.java, BaseActivity.createBundle())
        Activities.ACTIVITY_REPO_DETAILS -> buildIntent(RepoDetailsActivity::class.java, BaseActivity.createBundle())
        else -> throw UnsupportedOperationException("$screenKey is not supported")
    }

    private fun <T> buildIntent(className: Class<T>, extras: Bundle) = Intent(activity, className).putExtras(extras)
}
