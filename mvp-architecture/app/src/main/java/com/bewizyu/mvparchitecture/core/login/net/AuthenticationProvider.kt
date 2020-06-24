package com.bewizyu.mvparchitecture.core.login.net

import com.bewizyu.mvparchitecture.core.login.model.LoginRequest
import com.bewizyu.mvparchitecture.core.login.model.User
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit


class AuthenticationProvider {

    companion object API {
        const val BASE_URL = "https://demo0635484.mockable.io/"
        const val CONNECT_TIMEOUT : Long = 3000
    }

    private val authenticationService: AuthenticationService;

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()


        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
           .build()

        authenticationService = retrofit.create(AuthenticationService::class.java)
    }

    fun authenticate(loginRequest: LoginRequest): Call<User> {
        Timber.d("Authenticating ${loginRequest.email} ... ")
        return authenticationService.login()
    }
}