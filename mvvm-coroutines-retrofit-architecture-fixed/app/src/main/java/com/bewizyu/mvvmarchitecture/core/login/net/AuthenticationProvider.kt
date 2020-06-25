package com.bewizyu.mvvmarchitecture.core.login.net

import com.bewizyu.mvvmarchitecture.core.common.net.ApiConfiguration
import com.bewizyu.mvvmarchitecture.core.login.model.LoginRequest
import com.bewizyu.mvvmarchitecture.core.login.model.User
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit


class AuthenticationProvider {
    private val authenticationService: AuthenticationService by lazy {
        ApiConfiguration.retrofitInstance.create(AuthenticationService::class.java)
    }

    suspend fun authenticate(loginRequest: LoginRequest): User{
        Timber.d("Authenticating ${loginRequest.email} ... ")
        return authenticationService.login()
    }
}