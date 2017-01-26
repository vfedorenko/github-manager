package by.vfedorenko.githubmanager.entities.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
data class TokenResponse(@SerializedName("access_token") val token: String)
