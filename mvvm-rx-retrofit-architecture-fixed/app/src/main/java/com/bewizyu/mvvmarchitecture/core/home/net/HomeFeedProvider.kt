package com.bewizyu.mvvmarchitecture.core.home.net

import com.bewizyu.mvvmarchitecture.core.common.net.ApiConfiguration
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import io.reactivex.Single

class HomeFeedProvider {
    private val homeFeedService: HomeFeedService by lazy {
        ApiConfiguration.retrofitInstance.create(HomeFeedService::class.java)
    }

    fun retrieve(): Single<List<FeedItem>> {
        return homeFeedService.feeds()
    }
}