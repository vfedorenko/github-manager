package by.vfedorenko.githubmanager.entities.plain

import by.vfedorenko.githubmanager.presentation.App
import com.google.gson.annotations.SerializedName

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
data class User(
        val login: String = App.EMPTY_STRING,
        @SerializedName("avatar_url") val avatar: String = App.EMPTY_STRING
)
