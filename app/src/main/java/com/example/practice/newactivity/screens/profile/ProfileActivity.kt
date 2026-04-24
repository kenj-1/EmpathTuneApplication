package com.example.practice.newactivity.screens.profile

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.practice.newactivity.R
import com.example.practice.newactivity.app.CustomApp
import com.example.practice.newactivity.utils.toast
import android.content.Intent
import com.example.practice.newactivity.screens.dashboard.DashboardActivity
class ProfileActivity : Activity(), ProfileContract.View {

    private lateinit var presenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val app = application as CustomApp
        presenter = ProfilePresenter(this, ProfileModel(app))

        // ✅ Load user data
        presenter.loadUser()

        // ✅ Back button
        findViewById<ImageView>(R.id.iv_menu).setOnClickListener {
            finish()
        }

        // ✅ TEMP SAVE BUTTON (you can replace later)
        findViewById<ImageView>(R.id.iv_profile_photo).setOnClickListener {

            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val email = findViewById<EditText>(R.id.et_email).text.toString()

            presenter.saveUser(username, email)
        }

        findViewById<ImageView>(R.id.iv_home_nav).setOnClickListener {

            val intent = Intent(this, DashboardActivity::class.java)

            // ✅ Clears back stack so user doesn’t stack multiple screens
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK

            startActivity(intent)
            finish()
        }
    }

    override fun showUser(username: String, email: String) {

        // ✅ Header display
        findViewById<TextView>(R.id.tv_username_display).text = username

        // ✅ Editable fields
        findViewById<EditText>(R.id.et_username).setText(username)
        findViewById<EditText>(R.id.et_email).setText(email)
    }

    override fun showSavedMessage() {
        toast("Profile updated")
    }
}