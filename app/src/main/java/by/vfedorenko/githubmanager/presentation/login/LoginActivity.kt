package by.vfedorenko.githubmanager.presentation.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityLoginBinding
import by.vfedorenko.githubmanager.presentation.Activities
import by.vfedorenko.githubmanager.presentation.ActivityNavigator
import by.vfedorenko.githubmanager.presentation.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginActivity : BaseActivity() {
    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding.viewModel = viewModel

        viewModel.init(binding.webView)

        Activities.ACTIVITY_LOGIN
    }

    override fun getNavigator() = ActivityNavigator(this)
}
