package com.bewizyu.mvvmarchitecture.core.home.net

import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import io.reactivex.Single

interface HomeFeedService {
    //TODO-7 : utiliser les annotation Retrofit pour executer la requete suivante : https://demo0635484.mockable.io/feeds
    fun feeds(): Single<List<FeedItem>>

}