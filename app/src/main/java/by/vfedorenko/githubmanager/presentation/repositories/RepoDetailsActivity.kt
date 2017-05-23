package by.vfedorenko.githubmanager.presentation.repositories

import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityRepoDetailsBinding
import by.vfedorenko.githubmanager.presentation.ActivityNavigator
import by.vfedorenko.githubmanager.presentation.BaseActivity
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class RepoDetailsActivity : BaseActivity() {
    companion object {
//        fun createIntent(context: Context): Intent {
//            val intent = Intent(context, RepoDetailsActivity::class.java)
//            return intent
//        }
    }

    @Inject
    lateinit var viewModel: RepoDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityRepoDetailsBinding>(this, R.layout.activity_repo_details)
        binding.viewModel = viewModel

        Timber.tag("111").e("master viewModel = $viewModel")
    }

    override fun getNavigator() = ActivityNavigator(this)
}
