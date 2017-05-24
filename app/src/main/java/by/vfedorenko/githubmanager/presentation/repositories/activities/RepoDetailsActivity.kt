package by.vfedorenko.githubmanager.presentation.repositories.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityRepoDetailsBinding
import by.vfedorenko.githubmanager.presentation.ActivityNavigator
import by.vfedorenko.githubmanager.presentation.App
import by.vfedorenko.githubmanager.presentation.BaseActivity
import by.vfedorenko.githubmanager.presentation.repositories.viewmodels.RepoDetailsViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class RepoDetailsActivity : BaseActivity() {
    companion object {
        private const val EXTRA_REPO_ID = "repoId"

        fun buildBundle(repoId: Long): Bundle {
            val bundle = Bundle()
            bundle.putLong(EXTRA_REPO_ID, repoId)
            return bundle
        }
    }

    @Inject
    lateinit var viewModel: RepoDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityRepoDetailsBinding>(this, R.layout.activity_repo_details)
        binding.viewModel = viewModel

        val repoId = intent.getLongExtra(EXTRA_REPO_ID, App.ZERO)
        viewModel.init(repoId)
    }

    override fun getNavigator() = ActivityNavigator(this)
}
