package com.smarttransit.app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smarttransit.app.R
import com.smarttransit.app.model.NearbyLine

class NearbyLineAdapter(private val items: List<NearbyLine>) :
    RecyclerView.Adapter<NearbyLineAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: TextView = view.findViewById(R.id.tvModeIcon)
        val name: TextView = view.findViewById(R.id.tvLineName)
        val subtitle: TextView = view.findViewById(R.id.tvLineSubtitle)
        val eta: TextView = view.findViewById(R.id.tvEta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nearby_line, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.icon.text = item.icon
        holder.name.text = item.name
        holder.subtitle.text = item.subtitle
        holder.eta.text = item.eta
    }

    override fun getItemCount() = items.size
}