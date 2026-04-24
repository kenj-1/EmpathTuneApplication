package com.example.practice.newactivity.screens.profile

class ProfilePresenter(
    private val view: ProfileContract.View,
    private val model: ProfileModel
) : ProfileContract.Presenter {

    override fun loadUser() {
        val user = model.getUser()
        view.showUser(user.username, user.email)
    }

    override fun saveUser(username: String, email: String) {
        val user = model.getUser()
        user.username = username
        user.email = email

        view.showSavedMessage()
    }
}