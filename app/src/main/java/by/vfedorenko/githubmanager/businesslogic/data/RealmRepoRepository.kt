package by.vfedorenko.githubmanager.businesslogic.data

import by.vfedorenko.githubmanager.entities.plain.Repo
import by.vfedorenko.githubmanager.entities.realm.RealmRepo
import by.vfedorenko.githubmanager.entities.realm.RealmUser
import io.realm.Realm
import rx.Observable

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 25.05.17.
 */
class RealmRepoRepository: RepoRepository {
    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    //TODO: implement real synchronization
    override fun updateRepos(repos: List<Repo>) {
        realm.executeTransaction {
            realm.where(RealmRepo::class.java).findAll().deleteAllFromRealm()
            realm.where(RealmUser::class.java).findAll().deleteAllFromRealm()

            repos.forEach { (id, name, description, language, forksCount, starsCount, watchersCount, contentsUrl, owner) ->
                var user = RealmUser()
                user.login = owner.login
                user.avatar = owner.avatar

                user = realm.copyToRealmOrUpdate(user)

                val repo = RealmRepo()
                repo.id = id
                repo.name = name
                repo.description = description
                repo.language = language
                repo.forksCount = forksCount
                repo.starsCount = starsCount
                repo.watchersCount = watchersCount
                repo.contentsUrl = contentsUrl
                repo.owner = user

                realm.copyToRealmOrUpdate(repo)
            }
        }
    }

    override fun getRepos(): Observable<List<Repo>> =
            realm.where(RealmRepo::class.java).findAll().asObservable()
                .map { realmList ->
                    realmList.map { realmRepo ->
                        realmRepo.toPlainObject() } }

    override fun getRepo(id: Long): Observable<Repo> =
            realm.where(RealmRepo::class.java).equalTo("id", id).findFirst().asObservable<RealmRepo>()
                .map { it.toPlainObject() }
}
