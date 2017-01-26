package by.vfedorenko.githubmanager.businesslogic.utils

import android.content.Intent
import android.support.v7.app.AppCompatActivity

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
class NavigationManager(val activity: AppCompatActivity) {
    fun finishActivity() = activity.finish()
    fun startActivity(intent: Intent) = activity.startActivity(intent)
}
