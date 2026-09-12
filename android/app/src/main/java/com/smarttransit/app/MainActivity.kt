package com.smarttransit.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // That's it — the NavHostFragment in activity_main.xml handles everything.
        // It reads nav_graph.xml and starts at splashFragment automatically.
    }
}
