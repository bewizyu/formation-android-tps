package com.bewizyu.mvvmarchitecture.core.login.data.net.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("uid")
    val uid: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("fullName")
    val fullName: String?,
    @SerializedName("token")
    val token: String?
)