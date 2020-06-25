package com.bewizyu.mvvmarchitecture.core.login.net

import com.bewizyu.mvvmarchitecture.core.login.model.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.POST


interface AuthenticationService {
    @POST("login")
    fun login(): Single<User>
}
