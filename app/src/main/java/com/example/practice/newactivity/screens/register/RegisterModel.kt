package com.example.practice.newactivity.screens.register

import com.example.practice.newactivity.app.CustomApp

class RegisterModel(private val app: CustomApp) {

    fun saveUser(username: String, email: String, password: String) {
        val user = app.getUser()
        user.username = username
        user.email    = email       // ← Requirement 3: persist email for login lookup
        user.password = password
    }
}