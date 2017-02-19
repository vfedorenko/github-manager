package by.vfedorenko.githubmanager.presentation.login.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.databinding.ActivityLoginBinding
import by.vfedorenko.githubmanager.presentation.App
import by.vfedorenko.githubmanager.presentation.login.viewmodels.LoginViewModel
import by.vfedorenko.githubmanager.presentation.login.views.LoginView
import by.vfedorenko.githubmanager.presentation.login.views.OAuthWebView
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginView {

    @Inject
    lateinit var viewModel: LoginViewModel

    lateinit var OAuthWebView: OAuthWebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).injectMe(this)

        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding.viewModel = viewModel

        OAuthWebView = binding.webView as OAuthWebView

        viewModel.init(this)
    }

    override fun beginLogin() = OAuthWebView.beginLogin()

    override fun getContext() = this
}
