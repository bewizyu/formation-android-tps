package com.bewizyu.mvvmarchitecture.core.login.net

import com.bewizyu.mvvmarchitecture.core.common.net.ApiConfiguration
import com.bewizyu.mvvmarchitecture.core.login.data.net.model.LoginRequest
import com.bewizyu.mvvmarchitecture.core.login.domain.model.User
import timber.log.Timber


class AuthenticationProvider {
    private val authenticationService: AuthenticationService by lazy {
        ApiConfiguration.retrofitInstance.create(AuthenticationService::class.java)
    }

    suspend fun authenticate(loginRequest: LoginRequest): User {
        Timber.d("Authenticating ${loginRequest.email} ... ")
        return authenticationService.login()
    }
}