package by.vfedorenko.githubmanager.presentation.repositories

import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityReposBinding
import by.vfedorenko.githubmanager.presentation.ActivityNavigator
import by.vfedorenko.githubmanager.presentation.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class ReposActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: ReposViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityReposBinding>(this, R.layout.activity_repos)
        binding.viewModel = viewModel

        setupToolbar(binding.toolbar, showHomeAsBack = true)
    }

    override fun getNavigator() = ActivityNavigator(this)
}
