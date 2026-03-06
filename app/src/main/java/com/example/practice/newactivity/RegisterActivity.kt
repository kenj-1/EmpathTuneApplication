package com.example.practice.newactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Submit button → go back to Login (Instruction #2)
        val btnSubmit = findViewById<TextView>(R.id.btnCreateAccount)
        btnSubmit.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            // Clear back stack so user can't go back to Register
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // "Back to Login" link → go back to Login (Instruction #2)
        val tvBackToLogin = findViewById<TextView>(R.id.tvBackToLogin)
        tvBackToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}