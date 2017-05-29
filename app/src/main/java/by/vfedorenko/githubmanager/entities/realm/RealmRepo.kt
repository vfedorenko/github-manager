package by.vfedorenko.githubmanager.entities.realm

import by.vfedorenko.githubmanager.entities.plain.Repo
import by.vfedorenko.githubmanager.presentation.App
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.05.17.
 */
open class RealmRepo(
        @PrimaryKey
        open var id: Long = App.ZERO,
        open var name: String = App.EMPTY_STRING,
        open var description: String? = App.EMPTY_STRING,
        open var language: String? = App.EMPTY_STRING,
        open var forksCount: Int = App.ZERO.toInt(),
        open var starsCount: Int = App.ZERO.toInt(),
        open var watchersCount: Int = App.ZERO.toInt(),
        open var contentsUrl: String = App.EMPTY_STRING,
        open var owner: RealmUser = RealmUser()
) : RealmObject(), Plainable<Repo> {
    override fun toPlainObject() = Repo(
            id,
            name,
            description,
            language,
            forksCount,
            starsCount,
            watchersCount,
            contentsUrl,
            owner.toPlainObject()
    )
}
