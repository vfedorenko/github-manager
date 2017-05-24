package by.vfedorenko.githubmanager.presentation.repositories.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityReposBinding
import by.vfedorenko.githubmanager.presentation.ActivityNavigator
import by.vfedorenko.githubmanager.presentation.BaseActivity
import by.vfedorenko.githubmanager.presentation.repositories.viewmodels.ReposViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class ReposActivity : by.vfedorenko.githubmanager.presentation.BaseActivity() {

    @javax.inject.Inject
    lateinit var viewModel: by.vfedorenko.githubmanager.presentation.repositories.viewmodels.ReposViewModel

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        dagger.android.AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        val binding = android.databinding.DataBindingUtil.setContentView<by.vfedorenko.githubmanager.databinding.ActivityReposBinding>(this, by.vfedorenko.githubmanager.R.layout.activity_repos)
        binding.viewModel = viewModel

        setupToolbar(binding.toolbar, showHomeAsBack = true)
    }

    override fun getNavigator() = by.vfedorenko.githubmanager.presentation.ActivityNavigator(this)
}
