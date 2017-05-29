package by.vfedorenko.githubmanager.presentation.repositories.activities

import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityReposBinding
import by.vfedorenko.githubmanager.presentation.ActivityNavigator
import by.vfedorenko.githubmanager.presentation.repositories.viewmodels.ReposViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class ReposActivity : by.vfedorenko.githubmanager.presentation.BaseActivity() {

    @Inject
    lateinit var viewModel: ReposViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        val binding = android.databinding.DataBindingUtil.setContentView<ActivityReposBinding>(this, R.layout.activity_repos)
        binding.viewModel = viewModel

        setupToolbar(binding.toolbar)
    }

    override fun getNavigator() = ActivityNavigator(this)
}
