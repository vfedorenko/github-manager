package by.vfedorenko.githubmanager.presentation.login

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityLoginBinding
import by.vfedorenko.githubmanager.presentation.App
import by.vfedorenko.githubmanager.presentation.BaseActivity
import javax.inject.Inject

class LoginActivity : BaseActivity() {
    companion object {
        fun createIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).componentsManager.injectMe(this)

        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding.viewModel = viewModel

        viewModel.init(binding.webView)
    }

    override fun clearScope() {
        (application as App).componentsManager.clearLoginScope()
    }
}
