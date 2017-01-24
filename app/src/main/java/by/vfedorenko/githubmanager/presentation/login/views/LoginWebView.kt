package by.vfedorenko.githubmanager.presentation.login.views

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import rx.Observable
import rx.Subscriber

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.01.17.
 */
class LoginWebView(context: Context, attrs: AttributeSet): WebView(context, attrs) {
    companion object {
        const val AUTH_URL = "github.com/login/oauth/authorize"
        const val CLIENT_ID = "e1358db690c64012ea7f"
        const val SCOPE = "user repo"
        const val CALLBACK_URL = "vfedorenko.by"
    }

    init {
        settings.loadsImagesAutomatically = true
        settings.blockNetworkImage = false
        setWebViewClient(LoginWebViewClient())
    }

    var subscriber: Subscriber<in String>? = null

    inner class LoginWebViewClient() : WebViewClient() {
        override
        fun shouldOverrideUrlLoading(view: WebView, urlString: String): Boolean {
            Log.d("111", "Redirecting URL " + urlString)

            val uri = Uri.parse(urlString)

            if (uri.authority == CALLBACK_URL) {
                Log.d("111", "code " + uri.getQueryParameter("code"))

                if (subscriber != null && !subscriber!!.isUnsubscribed) {
                    subscriber?.onNext(uri.getQueryParameter("code"))
                    subscriber?.onCompleted()
                }
                return true
            }
            return false
        }
    }

    fun beginLogin(): Observable<String> {
        var authUri = Uri.Builder().scheme("https")
                .encodedAuthority(AUTH_URL)
                .appendQueryParameter("client_id", CLIENT_ID)
                //.appendQueryParameter("redirect_uri", CALLBACK_URL)
                .appendQueryParameter("scope", SCOPE)
                .build()

        return Observable.create {
            subscriber = it
            loadUrl(authUri.toString())
        }
    }
}
