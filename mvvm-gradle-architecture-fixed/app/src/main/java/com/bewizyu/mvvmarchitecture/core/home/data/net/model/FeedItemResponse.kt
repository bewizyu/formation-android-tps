package com.bewizyu.mvvmarchitecture.core.home.data.net.model

import com.google.gson.annotations.SerializedName

data class FeedItemResponse (
    @SerializedName("image")
    val image: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("likes")
    val likes: Int?,
    @SerializedName("date")
    val date: String?
)
