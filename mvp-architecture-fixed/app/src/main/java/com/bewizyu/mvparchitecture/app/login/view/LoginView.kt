package com.bewizyu.mvparchitecture.app.login.view

interface LoginView {

    fun showLoader()

    fun hideLoader()

    fun redirectToHome()

    fun showLoginError()

    fun showMessage(msg: String)
}