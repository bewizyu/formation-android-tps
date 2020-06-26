package com.bewizyu.mvvmarchitecture.core.login.domain.repository

import com.bewizyu.mvvmarchitecture.core.common.net.ApiConfiguration
import com.bewizyu.mvvmarchitecture.core.login.data.net.datasource.LoginApiDataSource
import com.bewizyu.mvvmarchitecture.core.login.data.net.mapper.UserMapper
import com.bewizyu.mvvmarchitecture.core.login.domain.model.User

class LoginRepositoryImpl : LoginRepository{
    private val loginApiDataSource: LoginApiDataSource by lazy {
        ApiConfiguration.retrofitInstance.create(LoginApiDataSource::class.java)
    }

    private val userMapper = UserMapper()

    override  suspend fun authenticate(email: String, password: String): User {
        val userResponse = loginApiDataSource.login()
        return userMapper.map(userResponse)
    }
}