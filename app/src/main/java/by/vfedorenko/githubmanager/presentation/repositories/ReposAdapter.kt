package by.vfedorenko.githubmanager.presentation.repositories

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.vfedorenko.githubmanager.BR
import by.vfedorenko.githubmanager.R
import by.vfedorenko.githubmanager.businesslogic.di.scopes.ActivityScope
import by.vfedorenko.githubmanager.databinding.ItemRepoBinding
import by.vfedorenko.githubmanager.entities.plain.Repo
import by.vfedorenko.githubmanager.presentation.repositories.viewmodels.RepoItemViewModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 23.05.17.
 */
@ActivityScope
class ReposAdapter
@Inject constructor(private val router: Router) : RecyclerView.Adapter<ReposAdapter.BindingHolder>() {

    class BindingHolder(item: View) : RecyclerView.ViewHolder(item) {
        var binding: ItemRepoBinding
            private set

        init {
            binding = DataBindingUtil.bind(item)
        }
    }

    val data: MutableList<Repo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            BindingHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_repo, parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BindingHolder?, position: Int) {
        val viewModel = RepoItemViewModel(router)
        viewModel.repo = data[position]

        holder?.binding?.setVariable(BR.viewModel, viewModel)
        holder?.binding?.executePendingBindings()
    }

    fun refreshItems(items: List<Repo>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
}
