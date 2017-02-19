package by.vfedorenko.githubmanager.presentation.repositories

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.businesslogic.utils.AuthUserManager
import by.vfedorenko.githubmanager.databinding.ActivityReposBinding
import by.vfedorenko.githubmanager.presentation.App
import by.vfedorenko.githubmanager.presentation.login.activities.LoginActivity
import by.vfedorenko.githubmanager.presentation.repositories.viewmodels.ReposViewModel
import javax.inject.Inject

class ReposActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context): Intent {
            val intent = Intent(context, ReposActivity::class.java)
            return intent
        }
    }

    @Inject
    lateinit var viewModel: ReposViewModel

    @Inject
    lateinit var authUserManager: AuthUserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).injectMe(this)

        val binding = DataBindingUtil.setContentView<ActivityReposBinding>(this, R.layout.activity_repos)
        binding.viewModel = viewModel

        if (authUserManager.getToken().isEmpty()) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
