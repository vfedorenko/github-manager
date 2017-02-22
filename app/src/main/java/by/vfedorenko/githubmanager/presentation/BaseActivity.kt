package by.vfedorenko.githubmanager.presentation

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import by.vfedorenko.githubmanager.R

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 21.02.17.
 */
abstract class BaseActivity : AppCompatActivity() {
    protected fun setupToolbar(toolbar: Toolbar?, title: String = App.EMPTY_STRING, showHomeAsBack: Boolean = false) {
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(showHomeAsBack)

        if (title.isNotEmpty()) {
            supportActionBar?.title = title
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.home -> {
            finish()
            true
        }
        else -> onOptionsItemSelected(item)
    }
}
