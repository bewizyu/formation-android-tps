package com.bewizyu.mvvmarchitecture.core.login.net

import com.bewizyu.mvvmarchitecture.core.login.model.User
import retrofit2.Call
import retrofit2.http.POST


// TODO-4 : retourner un Single au lieu de Call pour permettre l'utilisation de RxJava2

interface AuthenticationService {
    @POST("login")
    fun login(): Call<User>
}
