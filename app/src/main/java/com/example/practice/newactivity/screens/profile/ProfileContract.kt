package com.example.practice.newactivity.screens.profile

interface ProfileContract {

    interface View {
        fun showUser(username: String, email: String)
        fun showSavedMessage()
    }

    interface Presenter {
        fun loadUser()
        fun saveUser(username: String, email: String)
    }
}