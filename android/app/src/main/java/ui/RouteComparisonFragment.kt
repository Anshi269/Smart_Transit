package com.smarttransit.app.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarttransit.app.R
import com.smarttransit.app.model.RouteOption

class RouteComparisonFragment : Fragment(R.layout.fragment_route_comparison) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val destinationName = arguments?.getString("destinationName") ?: "Destination"

        view.findViewById<TextView>(R.id.tvRouteTitle).text =
            "HSR Layout → $destinationName"

        view.findViewById<View>(R.id.btnBack).setOnClickListener {
            findNavController().navigateUp()
        }

        val routes = listOf(
            RouteOption(
                typeLabel = "⚡ FASTEST",
                segmentIcons = "🚶 → 🛺 → 🚇 → 🚌 → 🚶",
                duration = "43 min",
                cost = "₹164",
                walkingDistance = "620m",
                isRecommended = false
            ),
            RouteOption(
                typeLabel = "💰 CHEAPEST",
                segmentIcons = "🚶 → 🚌 → 🚶",
                duration = "1h 18m",
                cost = "₹42",
                walkingDistance = "900m",
                isRecommended = false
            ),
            RouteOption(
                typeLabel = "⭐ SMART",
                segmentIcons = "🛺 → 🚇 → 🚌",
                duration = "51 min",
                cost = "₹78",
                walkingDistance = "250m",
                isRecommended = true
            )
        )

        val rv = view.findViewById<RecyclerView>(R.id.rvRoutes)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = RouteOptionAdapter(routes) { selected ->
            // TODO: navigate to Journey Map screen once built, passing the selected route
            Toast.makeText(requireContext(), "Selected: ${selected.typeLabel}", Toast.LENGTH_SHORT).show()
        }
    }
}