package by.vfedorenko.githubmanager.businesslogic.network

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com> on 26.01.17.
 */
class HttpException(val body: String?, val code: Int) : Exception(body)
