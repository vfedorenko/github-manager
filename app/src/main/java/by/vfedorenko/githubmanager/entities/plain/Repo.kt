package by.vfedorenko.githubmanager.entities.plain

import by.vfedorenko.githubmanager.presentation.App

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
data class Repo(
        val id: Long = App.ZERO,
        val name: String = App.EMPTY_STRING,
        val description: String = App.EMPTY_STRING,
        val owner: User = User()
)
