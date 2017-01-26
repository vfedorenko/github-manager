package by.vfedorenko.githubmanager.entities.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
data class AuthBody(val code: String) {
    companion object {
        private const val CLIENT_ID = "e1358db690c64012ea7f"
        private const val CLIENT_SECRET = "5493fa8aafb47fa6aa196064c9d88227b44fed5c"
    }

    @SerializedName("client_id")
    val clientId  = CLIENT_ID
    @SerializedName("client_secret")
    val clientSecret  = CLIENT_SECRET
}
