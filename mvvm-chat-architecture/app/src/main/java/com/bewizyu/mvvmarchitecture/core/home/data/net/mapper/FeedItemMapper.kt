package com.bewizyu.mvvmarchitecture.core.home.data.net.mapper

import com.bewizyu.mvvmarchitecture.core.common.mapper.Mapper
import com.bewizyu.mvvmarchitecture.core.home.data.net.model.FeedItemResponse
import com.bewizyu.mvvmarchitecture.core.home.domain.model.FeedItem

class FeedItemMapper: Mapper<FeedItemResponse, FeedItem> {
    override fun map(input: FeedItemResponse): FeedItem {
        return FeedItem(
            image = input.image ?: "",
            date = input.date ?: "",
            likes = input.likes ?: 0,
            title = input.title ?: "",
            description = input.description ?: ""
        )
    }
}