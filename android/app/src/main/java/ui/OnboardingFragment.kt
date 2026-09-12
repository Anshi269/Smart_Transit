package com.smarttransit.app.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smarttransit.app.R

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnContinue = view.findViewById<Button>(R.id.btnContinue)
        btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_onboarding_to_home)
        }
    }
}
