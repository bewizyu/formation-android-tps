package com.bewizyu.mvparchitecture.app.login.presenter

import com.bewizyu.mvparchitecture.app.login.view.LoginView
import com.bewizyu.mvparchitecture.core.login.model.LoginRequest
import com.bewizyu.mvparchitecture.core.login.model.User
import com.bewizyu.mvparchitecture.core.login.net.AuthenticationProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(
    private val loginView: LoginView,
    private val authenticationProvider: AuthenticationProvider
) {

    fun authenticate(email: String, password: String) {

        loginView.showLoader()

        authenticationProvider.authenticate(LoginRequest(email, password))
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    loginView.hideLoader()

                    if (response.body() != null) {
                        loginView.showMessage("Welcome ${response.body()?.fullName}")
                        loginView.redirectToHome()
                    } else {
                        loginView.showLoginError()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    loginView.showLoginError()
                }
            })
    }
}