package com.smarttransit.app.ui

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarttransit.app.R
import com.smarttransit.app.model.SearchResult

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val allResults = listOf(
        SearchResult("🕐", "Manyata Tech Park", "Nagawara, Bengaluru"),
        SearchResult("🕐", "HSR BDA Complex", "HSR Layout, Bengaluru"),
        SearchResult("📍", "Majestic Bus Stand", "Majestic, Bengaluru"),
        SearchResult("📍", "Silk Board Junction", "BTM Layout, Bengaluru"),
        SearchResult("📍", "Indiranagar Metro Station", "Indiranagar, Bengaluru")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btnBack).setOnClickListener {
            findNavController().navigateUp()
        }

        val rv = view.findViewById<RecyclerView>(R.id.rvSearchResults)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = SearchResultAdapter(allResults) { selected ->
            // TODO: navigate to Route Comparison screen once built, passing selected destination
            val bundle = bundleOf("destinationName" to selected.name)
            findNavController().navigate(R.id.action_search_to_routeComparison, bundle)
        }

        val etDestination = view.findViewById<EditText>(R.id.etDestination)
        etDestination.requestFocus()

        etDestination.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s?.toString()?.lowercase().orEmpty()
                val filtered = if (query.isBlank()) allResults
                else allResults.filter { it.name.lowercase().contains(query) }

                rv.adapter = SearchResultAdapter(filtered) { selected ->
                    val bundle = bundleOf("destinationName" to selected.name)
                    findNavController().navigate(R.id.action_search_to_routeComparison, bundle)
                }
            }
        })
    }
}