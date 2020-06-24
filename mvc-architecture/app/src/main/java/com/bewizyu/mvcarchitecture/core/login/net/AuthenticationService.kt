package com.bewizyu.mvcarchitecture.core.login.net

import com.bewizyu.mvcarchitecture.core.login.model.User
import retrofit2.Call
import retrofit2.http.GET


interface AuthenticationService {
    @GET("v3/61e677de-65b0-4e47-a66c-2a77f59f4408")
    fun login(): Call<User>
}
