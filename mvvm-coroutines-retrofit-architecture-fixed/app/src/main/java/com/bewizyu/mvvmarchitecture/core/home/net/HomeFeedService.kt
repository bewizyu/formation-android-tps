package com.bewizyu.mvvmarchitecture.core.home.net

import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import io.reactivex.Single
import retrofit2.http.GET

interface HomeFeedService {
    @GET("feeds")
    suspend fun feeds(): List<FeedItem>
}