package com.bewizyu.mvvmarchitecture.app.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem

class HomeViewModel : ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val showMessage = MutableLiveData<Boolean>()
    val feedItems = MutableLiveData<ArrayList<FeedItem>>()


    fun load() {
        val dataItems = ArrayList<FeedItem>()
        //TODO-9 : Remplacer les mocks par des données réels depuis l'api

        dataItems.add(
            FeedItem(
                image = "https://placeimg.com/640/480/people",
                title = "Jean Dupon",
                description = "Lorem iptsum Lorem iptsum Lorem iptsum Lorem iptsum Lorem iptsum Lorem iptsum ",
                date = "30 Juin",
                likes = 23
            )
        )

        dataItems.add(
            FeedItem(
                image = "https://placeimg.com/640/480/arch",
                title = "Alex Johan",
                description = "Lorem iptsum Lorem iptsum Lorem #Loram #Iptsum ",
                date = "22 Avril",
                likes = 232
            )
        )
        dataItems.add(
            FeedItem(
                image = "https://placeimg.com/640/480/any/sepia",
                title = "Maxim Alyan",
                description = "Hello from brazil ",
                date = "10 Mars",
                likes = 29
            )
        )


        loading.value = false
        showMessage.value = false
        feedItems.value = dataItems
    }
}