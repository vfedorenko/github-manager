package by.vfedorenko.githubmanager.entities.realm

import by.vfedorenko.githubmanager.entities.plain.User
import by.vfedorenko.githubmanager.presentation.App
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.05.17.
 */
open class RealmUser(
        @PrimaryKey
        open var login: String = App.EMPTY_STRING,
        open var avatar: String = App.EMPTY_STRING
) : RealmObject(), Plainable<User> {
    override fun toPlainObject() = User(login, avatar)
}
