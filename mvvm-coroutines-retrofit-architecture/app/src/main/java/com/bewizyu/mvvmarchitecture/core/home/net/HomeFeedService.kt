package com.bewizyu.mvvmarchitecture.core.home.net

import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import io.reactivex.Single
import retrofit2.http.GET

interface HomeFeedService {
    // TODO-1 : Modifier la methode pour que ca soit une coroutine en utilisant le mot clé suspend et modifier ainsi le type de retour
    @GET("feeds")
    fun feeds(): Single<List<FeedItem>>
}