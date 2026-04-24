package com.example.practice.newactivity.screens.register

class RegisterContract {

    interface View {
        fun showEmptyFields()
        fun showInvalidEmail()          // ← Requirement 2: new callback
        fun showPasswordMismatch()
        fun showSuccess()
        fun navigateToLogin()
    }

    interface Presenter {
        fun register(
            username: String,
            email: String,
            password: String,
            confirmPassword: String
        )
    }
}