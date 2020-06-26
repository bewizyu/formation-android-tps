package com.bewizyu.mvvmarchitecture.app.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bewizyu.mvvmarchitecture.core.login.data.net.model.LoginRequest
import com.bewizyu.mvvmarchitecture.core.login.domain.model.User
import com.bewizyu.mvvmarchitecture.core.login.domain.repository.LoginRepository
import com.bewizyu.mvvmarchitecture.core.login.domain.repository.LoginRepositoryImpl
import com.bewizyu.mvvmarchitecture.core.login.net.AuthenticationProvider
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginRepository  : LoginRepository) : ViewModel() {


    val loading = MutableLiveData<Boolean>()
    val userData = MutableLiveData<User>()
    val errorMessage = MutableLiveData<String>()


    fun authenticate(userEmail: String, userPassword: String) {
        loading.value = true
        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch {
            try {
                val user = loginRepository.authenticate(
                    email = userEmail,
                    password = userPassword
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