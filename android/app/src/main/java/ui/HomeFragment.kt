package com.smarttransit.app.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarttransit.app.R
import com.smarttransit.app.model.NearbyLine

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dummyData = listOf(
            NearbyLine("🚇", "Purple Line — Metro", "Silk Board • 4 min walk", "3 min"),
            NearbyLine("🚌", "Route 500 — BMTC", "HSR Layout Stop • 2 min walk", "6 min"),
            NearbyLine("🛺", "Auto stand", "Near you", "1 min"),
            NearbyLine("🚇", "Green Line — Metro", "Bommanahalli • 8 min walk", "12 min")
        )

        val rv = view.findViewById<RecyclerView>(R.id.rvNearby)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = NearbyLineAdapter(dummyData)

        view.findViewById<View>(R.id.searchBar).setOnClickListener {
            findNavController().navigate(R.id.action_home_to_search)
        }
    }
}