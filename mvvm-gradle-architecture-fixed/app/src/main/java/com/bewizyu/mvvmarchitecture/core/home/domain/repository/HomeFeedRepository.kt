package com.bewizyu.mvvmarchitecture.core.home.domain.repository

import com.bewizyu.mvvmarchitecture.core.home.domain.model.FeedItem

interface HomeFeedRepository {
    suspend fun retrieve() : List<FeedItem>
}