package com.example.practice.newactivity.screens.dashboard

import android.content.Context
import com.example.practice.newactivity.app.CustomApp
import com.example.practice.newactivity.data.User

class DashboardModel(private val context: Context) {

    fun getCurrentUser(): User {
        val app = context.applicationContext as CustomApp
        return app.getUser()
    }

    fun getGreeting(): String {
        val user = getCurrentUser()
        return "How are we feeling today, ${user.username}?"
    }
}