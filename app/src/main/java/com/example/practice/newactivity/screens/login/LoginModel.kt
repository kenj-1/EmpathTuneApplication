package com.example.practice.newactivity.screens.login

import com.example.practice.newactivity.app.CustomApp
import com.example.practice.newactivity.data.User

class LoginModel(private val app: CustomApp) {

    fun isValidCredentials(username: String, password: String): Boolean {
        val user: User = app.getUser()
        return user.username.equals(username, false)
                && user.password.equals(password, false)
    }
}