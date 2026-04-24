package com.example.practice.newactivity.screens.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.practice.newactivity.R
import com.example.practice.newactivity.app.CustomApp
import com.example.practice.newactivity.screens.dashboard.DashboardActivity
import com.example.practice.newactivity.screens.register.RegisterActivity
import com.example.practice.newactivity.utils.getEditTextValue
import com.example.practice.newactivity.utils.toast

class LoginActivity : Activity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val app = application as CustomApp
        presenter = LoginPresenter(this, LoginModel(app))

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val input    = getEditTextValue(R.id.etUsername).trim() // accepts username or email
            val password = getEditTextValue(R.id.etPassword).trim()
            presenter.validateCredentials(input, password)
        }

        // ← Requirement 1: navigate to Registration Screen
        findViewById<TextView>(R.id.tvRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun showEmptyMessage()       = toast("Fields cannot be empty")
    override fun showSuccessMessage()     = toast("Login successful")
    override fun showInvalidCredentials() = toast("Invalid username or password")

    override fun showDashboardScreen() {
        toast("Navigate to Dashboard")
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }
}