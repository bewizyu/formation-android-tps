package com.bewizyu.mvparchitecture.core.login.net

import com.bewizyu.mvparchitecture.core.login.model.User
import retrofit2.Call
import retrofit2.http.POST


interface AuthenticationService {
    @POST("login")
    fun login(): Call<User>
}
