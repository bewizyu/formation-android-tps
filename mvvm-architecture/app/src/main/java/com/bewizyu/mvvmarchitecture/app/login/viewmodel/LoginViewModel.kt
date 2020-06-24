package com.bewizyu.mvvmarchitecture.app.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bewizyu.mvvmarchitecture.core.login.model.LoginRequest
import com.bewizyu.mvvmarchitecture.core.login.model.User
import com.bewizyu.mvvmarchitecture.core.login.net.AuthenticationProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val userData = MutableLiveData<User>()
    val errorMessage = MutableLiveData<String>()

    private val authenticationProvider = AuthenticationProvider()


    fun authenticate(userEmail: String, userPassword: String){
        loading.value = true

        //TODO-11 : faire la meme chose pour LoginViewModel
    }

}