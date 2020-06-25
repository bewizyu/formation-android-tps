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

        // TODO-6 : adapter l'utilisation de authenticate() afin de prendre en consideration le type de retour Single
        // HINT :
        // observale.getUsers ()
        //                .subscribeOn(Schedulers.io())
        //                .observeOn(AndroidSchedulers.mainThread())
        //                .subscribeWith(object : DisposableSingleObserver<User>(){
        //                    override fun onSuccess(user: User) {
        //                    }
        //                    override fun onError(e: Throwable) {
        //                    }
        //                })

        authenticationProvider.authenticate(LoginRequest(
            email = userEmail,
            password = userPassword
        )).enqueue(object : Callback<User>{

            override fun onFailure(call: Call<User>, t: Throwable) {
                loading.value = false
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {

                loading.value = false
                val user = response.body()

                if(user != null){
                    userData.value = user
                } else {
                    errorMessage.value = "Email et/ou mot de passe incorrecte(s)"
                }

            }
        })
    }

}