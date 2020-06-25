package com.bewizyu.mvvmarchitecture.core.home.net

import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import io.reactivex.Single


class HomeFeedProvider {
    //TODO-8 : instancier et faire appel au service HomeFeedService pour retourner les données de l'api

    fun retrieve(): Single<List<FeedItem>> {
        return TODO()
    }
}