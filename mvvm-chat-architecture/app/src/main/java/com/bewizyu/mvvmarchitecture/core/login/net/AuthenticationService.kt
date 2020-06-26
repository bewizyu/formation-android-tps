package com.bewizyu.mvvmarchitecture.core.login.net

import com.bewizyu.mvvmarchitecture.core.login.domain.model.User
import retrofit2.http.POST


interface AuthenticationService {
    @POST("login")
    suspend fun login(): User
}
