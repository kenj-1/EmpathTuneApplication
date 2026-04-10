package com.example.practice.newactivity.screens.login

class LoginPresenter(
    private val view: LoginContract.View,
    private val model: LoginModel
) : LoginContract.Presenter {

    override fun validateCredentials(username: String, password: String) {

        if (username.isEmpty() || password.isEmpty()) {
            view.showEmptyMessage()
        } else {
            if (model.isValidCredentials(username, password)) {
                view.showSuccessMessage()
                view.showDashboardScreen()
            } else {
                view.showInvalidCredentials()
            }
        }
    }
}