package com.bewizyu.mvvmarchitecture.app.home.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import com.bewizyu.mvvmarchitecture.core.home.net.HomeFeedProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {
    val loading = ObservableField<Boolean>()
    val showMessage = ObservableField<Boolean>()
    val feedItems = MutableLiveData<ArrayList<FeedItem>>()
    private val homeFeedProvider = HomeFeedProvider()
    private val subscriptions = CompositeDisposable()
    // TODO-5 : retirer subscriptions et onCleared()


    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }
    fun load() {
        // TODO-3 : récuperer les données en utilisant coroutine au lieu de Rx
        // HINT :
        // viewModelScope is a predefined CoroutineScope that is included with the ViewModel KTX extensions.
        // viewModelScope is a predefined CoroutineScope that is included with the ViewModel KTX extensions.
        // launch is a function that creates a coroutine and dispatches the execution of its function body to the corresponding dispatcher.
        // viewModelScope.launch{ ... }

        // TODO-4 : garder le même comportement de gestion des erreurs

        loading.set(true)
        showMessage.set(false)
        subscriptions.add(
            homeFeedProvider.retrieve()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<FeedItem>>(){
                    override fun onSuccess(data: List<FeedItem>) {
                        loading.set(false)
                        feedItems.value = ArrayList(data)

                    }
                    override fun onError(e: Throwable) {
                        loading.set(false)
                        showMessage.set(true)
                        feedItems.value = ArrayList()

                    }

                })
        )

    }
}