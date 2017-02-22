package by.vfedorenko.githubmanager.presentation.repositories

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityReposBinding
import by.vfedorenko.githubmanager.presentation.App
import by.vfedorenko.githubmanager.presentation.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class ReposActivity : BaseActivity() {
    companion object {
        fun createIntent(context: Context): Intent {
            val intent = Intent(context, ReposActivity::class.java)
            return intent
        }
    }

    @Inject
    lateinit var viewModel: ReposViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).componentsManager.injectMe(this)

        val binding = DataBindingUtil.setContentView<ActivityReposBinding>(this, R.layout.activity_repos)
        binding.viewModel = viewModel

        setupToolbar(binding.toolbar, showHomeAsBack = true)

        Timber.tag("111").e("master viewModel = $viewModel")
    }

    override fun clearScope() {
        (application as App).componentsManager.clearReposScope()
    }
}
