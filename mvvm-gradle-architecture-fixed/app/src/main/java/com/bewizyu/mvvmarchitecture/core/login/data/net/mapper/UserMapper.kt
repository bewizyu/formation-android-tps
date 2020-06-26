package com.bewizyu.mvvmarchitecture.core.login.data.net.mapper

import com.bewizyu.mvvmarchitecture.core.common.mapper.Mapper
import com.bewizyu.mvvmarchitecture.core.login.data.net.model.UserResponse
import com.bewizyu.mvvmarchitecture.core.login.domain.model.User

class UserMapper: Mapper<UserResponse, User> {
    override fun map(input: UserResponse): User {
        return User(
            fullName = input.fullName ?: "",
            email = input.email ?: ""
        )
    }
}