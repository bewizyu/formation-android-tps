package com.bewizyu.mvvmarchitecture.core.login.data.net.datasource

import com.bewizyu.mvvmarchitecture.core.login.data.net.model.UserResponse
import retrofit2.http.POST

interface LoginApiDataSource {
    @POST("login")
    suspend fun login(): UserResponse

}