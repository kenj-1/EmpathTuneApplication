package com.example.practice.newactivity.screens.login

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.newactivity.R
import com.example.practice.newactivity.app.CustomApp
import com.example.practice.newactivity.utils.getEditTextValue
import com.example.practice.newactivity.utils.toast

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val app = application as CustomApp
        val model = LoginModel(app)
        presenter = LoginPresenter(this, model)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {

            val username = getEditTextValue(R.id.etUsername).trim()
            val password = getEditTextValue(R.id.etPassword).trim()

            presenter.validateCredentials(username, password)
        }
    }

    override fun showEmptyMessage() {
        toast("Fields cannot be empty")
    }

    override fun showSuccessMessage() {
        toast("Login successful")
    }

    override fun showInvalidCredentials() {
        toast("Invalid username or password ❌")
    }

    override fun showDashboardScreen() {
        toast("Navigate to Dashboard 🚀")
        // TODO: startActivity(Intent(this, DashboardActivity::class.java))
    }
}