package com.example.practice.newactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DashboardActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Nav icon (Profile) → go to Profile Screen (Instruction #4)
        val ivNavIcon = findViewById<ImageView>(R.id.iv_nav_icon)
        ivNavIcon.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // Logout → go back to Login Screen (Instruction #5)
        val tvLogout = findViewById<TextView>(R.id.tv_logout)
        tvLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            // Clear back stack so user can't go back to Dashboard after logout
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}