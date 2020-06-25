package com.bewizyu.mvvmarchitecture.app.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bewizyu.mvvmarchitecture.core.login.model.LoginRequest
import com.bewizyu.mvvmarchitecture.core.login.model.User
import com.bewizyu.mvvmarchitecture.core.login.net.AuthenticationProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginViewModel : ViewModel() {

    private val authenticationProvider = AuthenticationProvider()

    val loading = MutableLiveData<Boolean>()
    val userData = MutableLiveData<User>()
    val errorMessage = MutableLiveData<String>()


    fun authenticate(userEmail: String, userPassword: String) {
        loading.value = true
        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch {
            try {
                val user = authenticationProvider.authenticate(
                    LoginRequest(
                        email = userEmail,
                        password = userPassword
                    )
                )
                loading.value = false
                userData.value = user
            } catch (e: Exception) {
                loading.value = false
                errorMessage.value = "Email et/ou mot de passe incorrecte(s)"

            }
        }

    }

}