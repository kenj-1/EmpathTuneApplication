package com.example.practice.newactivity.screens.login

import com.example.practice.newactivity.app.CustomApp

class LoginModel(private val app: CustomApp) {

    fun isValidCredentials(input: String, password: String): Boolean {
        val user = app.getUser()

        // accepts either username or email as the login identifier
        val inputMatchesUsername = user.username == input
        val inputMatchesEmail    = user.email == input

        return (inputMatchesUsername || inputMatchesEmail) && user.password == password
    }
}