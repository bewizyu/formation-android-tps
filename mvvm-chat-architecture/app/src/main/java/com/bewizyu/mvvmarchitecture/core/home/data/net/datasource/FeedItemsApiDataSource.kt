package com.bewizyu.mvvmarchitecture.core.home.data.net.datasource

import com.bewizyu.mvvmarchitecture.core.home.data.net.model.FeedItemResponse
import retrofit2.http.GET

interface FeedItemsApiDataSource {
    @GET("feeds")
    suspend fun feeds(): List<FeedItemResponse>
}