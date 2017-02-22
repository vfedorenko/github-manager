package by.vfedorenko.githubmanager.presentation.repositories

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityRepoDetailsBinding
import by.vfedorenko.githubmanager.presentation.App
import by.vfedorenko.githubmanager.presentation.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class RepoDetailsActivity : BaseActivity() {
    companion object {
        fun createIntent(context: Context): Intent {
            val intent = Intent(context, RepoDetailsActivity::class.java)
            return intent
        }
    }

    @Inject
    lateinit var viewModel: RepoDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).componentsManager.injectMe(this)

        val binding = DataBindingUtil.setContentView<ActivityRepoDetailsBinding>(this, R.layout.activity_repo_details)
        binding.viewModel = viewModel

        Timber.tag("111").e("master viewModel = $viewModel")
    }

    override fun clearScope() {
        (application as App).componentsManager.clearRepoDetailsScope()
    }
}
