package com.bewizyu.mvvmarchitecture.core.login.net

import com.bewizyu.mvvmarchitecture.core.login.model.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.POST


interface AuthenticationService {
    // TODO-6 : appliquer les mêmes modifications sur les composantes du module Login
    @POST("login")
    fun login(): Single<User>


}
