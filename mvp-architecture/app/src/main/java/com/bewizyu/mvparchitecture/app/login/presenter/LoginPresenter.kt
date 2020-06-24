package com.bewizyu.mvparchitecture.app.login.presenter

import com.bewizyu.mvparchitecture.app.login.view.LoginView
import com.bewizyu.mvparchitecture.core.login.net.AuthenticationProvider

class LoginPresenter(
    private val loginView: LoginView,
    private val authenticationProvider: AuthenticationProvider
) {

    fun authenticate(email: String, password: String) {

        // TODO-3 : implementer la methode authenticate de tel façon a :
        // afficher le loader
        // faire appelle au service via authenticationProvider et recuprer la reponse
        // si c'est succees et que les données de l'utilisateur sont bons afficher un message de bienvenu et rediriger l'utilisateur vers la page Home
        // sinon afficher un message d'erreur, tous ça via l'instance loginView

    }
}