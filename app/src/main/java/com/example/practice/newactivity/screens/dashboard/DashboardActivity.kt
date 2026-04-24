package com.example.practice.newactivity.screens.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.practice.newactivity.screens.profile.ProfileActivity
import com.example.practice.newactivity.R
import com.example.practice.newactivity.screens.login.LoginActivity

class DashboardActivity : Activity(), DashboardContract.View {

    private lateinit var presenter: DashboardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val model = DashboardModel(this)
        presenter = DashboardPresenter(this, model)
        presenter.loadData()

        findViewById<ImageView>(R.id.iv_nav_icon).setOnClickListener {
            presenter.onProfileClicked()
        }

        findViewById<TextView>(R.id.tv_logout).setOnClickListener {
            presenter.onLogoutClicked()
        }
    }

    override fun navigateToProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    override fun logout() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
    override fun showGreeting(text: String) {
        findViewById<TextView>(R.id.tv_greeting).text = text
    }
}