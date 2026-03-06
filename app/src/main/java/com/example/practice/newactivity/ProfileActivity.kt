package com.example.practice.newactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // "Back to Dashboard" → return to Dashboard Screen (Instruction #6)
        val tvBackToDashboard = findViewById<ImageView>(R.id.iv_menu)
        tvBackToDashboard.setOnClickListener {
            finish() // Simply pop ProfileActivity off the stack → returns to Dashboard
        }
    }
}