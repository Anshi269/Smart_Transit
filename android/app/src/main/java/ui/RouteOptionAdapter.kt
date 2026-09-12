package com.smarttransit.app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smarttransit.app.R
import com.smarttransit.app.model.RouteOption

class RouteOptionAdapter(
    private val items: List<RouteOption>,
    private val onItemClick: (RouteOption) -> Unit
) : RecyclerView.Adapter<RouteOptionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val type: TextView = view.findViewById(R.id.tvRouteType)
        val recommended: TextView = view.findViewById(R.id.tvRecommended)
        val segments: TextView = view.findViewById(R.id.tvSegments)
        val duration: TextView = view.findViewById(R.id.tvDuration)
        val cost: TextView = view.findViewById(R.id.tvCost)
        val walking: TextView = view.findViewById(R.id.tvWalking)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_route_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.type.text = item.typeLabel
        holder.segments.text = item.segmentIcons
        holder.duration.text = item.duration
        holder.cost.text = item.cost
        holder.walking.text = item.walkingDistance
        holder.recommended.visibility = if (item.isRecommended) View.VISIBLE else View.GONE
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount() = items.size
}