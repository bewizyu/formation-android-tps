package com.bewizyu.mvvmarchitecture.app.home.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import com.bewizyu.mvvmarchitecture.core.home.net.HomeFeedProvider
import com.bewizyu.mvvmarchitecture.core.login.model.LoginRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel : ViewModel() {
    val loading = ObservableField<Boolean>()
    val showMessage = ObservableField<Boolean>()
    val feedItems = MutableLiveData<ArrayList<FeedItem>>()
    private val homeFeedProvider = HomeFeedProvider()


    fun load() {
        loading.set(true)
        showMessage.set(false)
        viewModelScope.launch {
            try {
                val feeds = homeFeedProvider.retrieve()
                loading.set(false)
                feedItems.value = ArrayList(feeds)
            } catch (e: Exception) {
                loading.set(false)
                showMessage.set(true)
                feedItems.value = ArrayList()
            }
        }
    }
}