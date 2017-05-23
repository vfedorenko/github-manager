package by.vfedorenko.githubmanager.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import by.vfedorenko.githubmanager.R
import dagger.android.AndroidInjection
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 21.02.17.
 */
abstract class BaseActivity : AppCompatActivity() {
    companion object {
        fun createBundle() = Bundle()
    }

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState, persistentState)
    }

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
        else -> super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(getNavigator())
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

    abstract fun getNavigator(): Navigator
}
