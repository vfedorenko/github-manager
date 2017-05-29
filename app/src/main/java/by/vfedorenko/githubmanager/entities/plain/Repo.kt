package by.vfedorenko.githubmanager.entities.plain

import by.vfedorenko.githubmanager.presentation.App
import com.google.gson.annotations.SerializedName

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
data class Repo(
        val id: Long = App.ZERO,
        val name: String = App.EMPTY_STRING,
        val description: String? = App.EMPTY_STRING,
        val language: String? = App.EMPTY_STRING,
        @SerializedName("forks_count")
        val forksCount: Int = App.ZERO.toInt(),
        @SerializedName("stargazers_count")
        val starsCount: Int = App.ZERO.toInt(),
        @SerializedName("watchers_count")
        val watchersCount: Int = App.ZERO.toInt(),
        @SerializedName("contents_url")
        val contentsUrl: String = App.EMPTY_STRING,
        val owner: User = User()
)
