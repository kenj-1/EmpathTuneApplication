package com.example.practice.newactivity.screens.dashboard

class DashboardPresenter(
    private val view: DashboardContract.View,
    private val model: DashboardModel
) : DashboardContract.Presenter {

    fun loadData() {
        val greeting = model.getGreeting()
        view.showGreeting(greeting)
    }

    override fun onProfileClicked() {
        view.navigateToProfile()
    }

    override fun onLogoutClicked() {
        view.logout()
    }
}