package com.smarttransit.app.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smarttransit.app.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Wait 1.5 seconds, then move to Onboarding automatically
        Handler(Looper.getMainLooper()).postDelayed({
            if (isAdded) {
                findNavController().navigate(R.id.action_splash_to_onboarding)
            }
        }, 1500)
    }
}
