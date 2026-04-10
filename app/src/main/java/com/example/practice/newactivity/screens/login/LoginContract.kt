package com.example.practice.newactivity.screens.login

class LoginContract {

    interface View {
        fun showEmptyMessage()
        fun showSuccessMessage()
        fun showInvalidCredentials()
        fun showDashboardScreen()
    }

    interface Presenter {
        fun validateCredentials(username: String, password: String)
    }
}