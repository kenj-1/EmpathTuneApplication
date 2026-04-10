package com.example.practice.newactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.practice.newactivity.screens.dashboard.DashboardActivity
import com.example.practice.newactivity.screens.register.RegisterActivity

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Login button → go to Dashboard (Instruction #3)
        val btnLogin = findViewById<TextView>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }



        // "Create new account" link → go to Register (Instruction #1)
        val tvCreateAccount = findViewById<TextView>(R.id.btnNoAccountClickherePlease)
        tvCreateAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}