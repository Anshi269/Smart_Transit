package com.smarttransit.app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smarttransit.app.R
import com.smarttransit.app.model.SearchResult

class SearchResultAdapter(
    private val items: List<SearchResult>,
    private val onItemClick: (SearchResult) -> Unit
) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: TextView = view.findViewById(R.id.tvResultIcon)
        val name: TextView = view.findViewById(R.id.tvResultName)
        val address: TextView = view.findViewById(R.id.tvResultAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.icon.text = item.icon
        holder.name.text = item.name
        holder.address.text = item.address
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount() = items.size
}