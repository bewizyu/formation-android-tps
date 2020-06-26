package com.bewizyu.mvvmarchitecture.app.home.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bewizyu.mvvmarchitecture.core.home.domain.model.FeedItem
import com.bewizyu.mvvmarchitecture.core.home.domain.repository.HomeFeedRepository
import com.bewizyu.mvvmarchitecture.core.home.domain.repository.HomeFeedRepositoryImpl
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeFeedRepository: HomeFeedRepository) : ViewModel() {


    val loading = ObservableField<Boolean>()
    val showMessage = ObservableField<Boolean>()
    val feedItems = MutableLiveData<ArrayList<FeedItem>>()


    fun load() {
        loading.set(true)
        showMessage.set(false)
        viewModelScope.launch {
            try {
                val feeds = homeFeedRepository.retrieve()
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