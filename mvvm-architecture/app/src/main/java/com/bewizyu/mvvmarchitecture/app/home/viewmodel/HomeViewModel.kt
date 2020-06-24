package com.bewizyu.mvvmarchitecture.app.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem

class HomeViewModel : ViewModel() {
    //TODO-7 : ce viewModel est responsable de l'affichage des elements de la liste ainsi que l'affichage du chargement et du message d'erreur
    // Pour cela il faut declarer 3 attributs val loading, val showMessage, val feedItems de type MutableLiveData qui vont porter les valeurs à transmettre à la vue




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

        //TODO-8 : initialiser les valeurs des differents champs MutableLiveData ex : loading.value = false
    }
}