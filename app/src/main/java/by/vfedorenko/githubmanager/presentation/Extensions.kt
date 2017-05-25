package by.vfedorenko.githubmanager.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.05.17.
 */
inline fun <reified T: Activity> Activity.startActivity(bundle: Bundle) {
    val intent = Intent(this, T::class.java)
    intent.putExtras(bundle)
    startActivity(intent)
}
