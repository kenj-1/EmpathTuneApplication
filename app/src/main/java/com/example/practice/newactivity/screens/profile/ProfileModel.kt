package com.example.practice.newactivity.screens.profile

import com.example.practice.newactivity.app.CustomApp

class ProfileModel(private val app: CustomApp) {

    fun getUser() = app.getUser()
}