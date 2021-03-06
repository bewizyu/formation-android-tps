package com.bewizyu.mvvmarchitecture.app.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem

class HomeViewModel : ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val showMessage = MutableLiveData<Boolean>()
    val feedItems = MutableLiveData<ArrayList<FeedItem>>()

    fun load() {
        val dataItems = ArrayList<FeedItem>()
        dataItems.add(
            FeedItem(
                image = "",
                title = "Jean Dupon",
                description = "Lorem iptsum Lorem iptsum Lorem iptsum Lorem iptsum Lorem iptsum Lorem iptsum ",
                date = "30 Juin",
                likes = 23
            )
        )

        dataItems.add(
            FeedItem(
                image = "",
                title = "Alex Johan",
                description = "Lorem iptsum Lorem iptsum Lorem #Loram #Iptsum ",
                date = "22 Avril",
                likes = 232
            )
        )
        dataItems.add(
            FeedItem(
                image = "",
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