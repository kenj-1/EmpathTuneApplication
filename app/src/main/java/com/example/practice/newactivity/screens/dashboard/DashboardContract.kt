package com.example.practice.newactivity.screens.dashboard

class DashboardContract {

    interface View {
        fun navigateToProfile()
        fun logout()
        fun showGreeting(text: String)
    }

    interface Presenter {
        fun onProfileClicked()
        fun onLogoutClicked()
    }
}