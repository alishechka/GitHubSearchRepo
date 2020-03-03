package com.example.github_searchrepo.adapter

import RepositoriesModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.github_searchrepo.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.search_repo_item.view.*

class SearchAdapter(private val models: RepositoriesModel) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.search_repo_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return models.items.size

    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.name.text = models.items[position].name
    }

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tv_display_search_result
    }
}