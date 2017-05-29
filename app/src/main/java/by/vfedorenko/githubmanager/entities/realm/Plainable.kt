package by.vfedorenko.githubmanager.entities.realm

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.05.17.
 */
interface Plainable <out P> {
    fun toPlainObject(): P
}
