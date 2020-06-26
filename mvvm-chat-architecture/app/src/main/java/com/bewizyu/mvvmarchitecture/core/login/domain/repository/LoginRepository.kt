package com.bewizyu.mvvmarchitecture.core.login.domain.repository

import com.bewizyu.mvvmarchitecture.core.login.domain.model.User

interface LoginRepository {
    suspend fun authenticate(email: String, password: String): User
}