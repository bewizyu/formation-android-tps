package com.bewizyu.mvcarchitecture.core.login.net

import com.bewizyu.mvcarchitecture.core.login.model.LoginRequest
import com.bewizyu.mvcarchitecture.core.login.model.User
import retrofit2.Call
import timber.log.Timber


class AuthenticationProvider {

    companion object API {
        const val BASE_URL = "https://run.mocky.io/"
        const val CONNECT_TIMEOUT : Long = 3000
    }

    // private val authenticationService: AuthenticationService;

    init {
        // TODO-2 : construire le client OKHTTP et Retrofit avec les bons parametres (GSON, base_url, timeout ... ) dans le constructeur de la classe

        // TODO-3 : utiliser retrofit pour instancier AuthenticationService

    }

    fun authenticate(loginRequest: LoginRequest): Call<User> {
        Timber.d("Authenticating ${loginRequest.email} ... ")

        // TODO-4: faire appel a la bonne methode pour envoyer la requete d'authentification

        return TODO()
    }
}