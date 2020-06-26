package com.bewizyu.mvvmarchitecture.core.home.domain.model

data class FeedItem(
    val image: String,
    val title: String,
    val description: String,
    val likes: Int,
    val date: String
)