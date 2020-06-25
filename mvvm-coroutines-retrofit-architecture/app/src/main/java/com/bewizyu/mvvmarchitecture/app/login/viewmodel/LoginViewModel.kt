package com.bewizyu.mvvmarchitecture.app.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bewizyu.mvvmarchitecture.core.login.model.LoginRequest
import com.bewizyu.mvvmarchitecture.core.login.model.User
import com.bewizyu.mvvmarchitecture.core.login.net.AuthenticationProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel : ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val userData = MutableLiveData<User>()
    val errorMessage = MutableLiveData<String>()

    private val subscriptions = CompositeDisposable()
    private val authenticationProvider = AuthenticationProvider()

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }

    fun authenticate(userEmail: String, userPassword: String) {
        loading.value = true

        subscriptions.add(
            authenticationProvider.authenticate(
                LoginRequest(
                    email = userEmail,
                    password = userPassword
                )
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<User>(){
                    override fun onSuccess(user: User) {
                        loading.value = false
                        userData.value = user
                    }
                    override fun onError(e: Throwable) {
                        loading.value = false
                        errorMessage.value = "Email et/ou mot de passe incorrecte(s)"
                    }

                })
        )
    }

}