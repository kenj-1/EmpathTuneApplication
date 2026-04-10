package com.example.practice.newactivity.app

import android.app.Application
import android.util.Log
import com.example.practice.newactivity.data.User

class CustomApp: Application(){

    private val user = User("text", "123456")
    override fun onCreate(){
        super.onCreate()

        Log.e("Custom App", "onCreate is called")
    }


    fun getUser() = this.user

}