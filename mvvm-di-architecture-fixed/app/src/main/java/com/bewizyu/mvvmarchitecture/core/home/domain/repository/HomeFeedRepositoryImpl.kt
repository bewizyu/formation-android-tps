package com.bewizyu.mvvmarchitecture.core.home.domain.repository

import com.bewizyu.mvvmarchitecture.core.common.net.ApiConfiguration
import com.bewizyu.mvvmarchitecture.core.home.data.net.datasource.FeedItemsApiDataSource
import com.bewizyu.mvvmarchitecture.core.home.data.net.mapper.FeedItemMapper
import com.bewizyu.mvvmarchitecture.core.home.domain.model.FeedItem

class HomeFeedRepositoryImpl : HomeFeedRepository{

    private val feedItemsApiDataSource: FeedItemsApiDataSource by lazy {
        ApiConfiguration.retrofitInstance.create(FeedItemsApiDataSource::class.java)
    }

    private val feedItemMapper = FeedItemMapper()

    override suspend fun retrieve() : List<FeedItem>{
        return feedItemsApiDataSource.feeds().map { feedItemMapper.map(it) }
    }

}