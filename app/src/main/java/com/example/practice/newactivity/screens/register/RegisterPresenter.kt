package com.example.practice.newactivity.screens.register

class RegisterPresenter(
    private val view: RegisterContract.View,
    private val model: RegisterModel
) : RegisterContract.Presenter {

    // Requirement 2: pure Kotlin regex — no Android imports needed
    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        return emailRegex.matches(email)
    }

    override fun register(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        if (username.isEmpty() || email.isEmpty() ||
            password.isEmpty() || confirmPassword.isEmpty()) {
            view.showEmptyFields()
            return
        }

        // Requirement 2: validate email format before anything else
        if (!isValidEmail(email)) {
            view.showInvalidEmail()
            return
        }

        if (password != confirmPassword) {
            view.showPasswordMismatch()
            return
        }

        model.saveUser(username, email, password)   // ← pass email to model
        view.showSuccess()
        view.navigateToLogin()
    }
}