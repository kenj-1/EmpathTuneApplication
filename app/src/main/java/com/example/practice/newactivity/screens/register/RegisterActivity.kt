package com.example.practice.newactivity.screens.register

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.example.practice.newactivity.R
import com.example.practice.newactivity.app.CustomApp
import com.example.practice.newactivity.screens.login.LoginActivity
import com.example.practice.newactivity.utils.toast

class RegisterActivity : Activity(), RegisterContract.View {

    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val cb = findViewById<CheckBox>(R.id.cbTerms)
        val s = SpannableString("I accepted the Terms and Conditions")
        s.setSpan(StyleSpan(Typeface.BOLD), 15, s.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        cb.text = s

        val app = application as CustomApp
        presenter = RegisterPresenter(this, RegisterModel(app))

        val btnSubmit = findViewById<TextView>(R.id.btnCreateAccount)

        btnSubmit.setOnClickListener {
            val username = findViewById<EditText>(R.id.etRegisterUsername).text.toString().trim()
            val email    = findViewById<EditText>(R.id.etRegisterEmail).text.toString().trim()
            val password = findViewById<EditText>(R.id.etRegisterPassword).text.toString().trim()
            val confirm  = findViewById<EditText>(R.id.etConfirmPassword).text.toString().trim()

            presenter.register(username, email, password, confirm)
        }

        findViewById<TextView>(R.id.tvBackToLogin).setOnClickListener {
            navigateToLogin()
        }
    }

    override fun showEmptyFields()    = toast("All fields required")
    override fun showInvalidEmail()   = toast("Please enter a valid email address") // ← new
    override fun showPasswordMismatch() = toast("Passwords do not match")
    override fun showSuccess()        = toast("Credentials saved")

    override fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}