package com.bewizyu.mvcarchitecture.app.login.controller

import android.app.ProgressDialog
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bewizyu.mvcarchitecture.R
import com.bewizyu.mvcarchitecture.app.home.controller.HomeActivity
import com.bewizyu.mvcarchitecture.core.login.model.LoginRequest
import com.bewizyu.mvcarchitecture.core.login.model.User
import com.bewizyu.mvcarchitecture.core.login.net.AuthenticationProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity(), Callback<User>{

    private lateinit var buttonSignIn: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var loadingDialog: ProgressDialog

    private lateinit var authenticationProvider: AuthenticationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)
        initViewComponents()
        initProviders()
    }

    private fun initViewComponents(){
        loadingDialog = ProgressDialog.show(
            this@LoginActivity, "",
            resources.getString(R.string.loading), true
        )
        loadingDialog.hide()
        // TODO-1 : initialiser les composantes de la vue et ajouter un evenement de click sur le buttonSignIn

    }

    private fun initProviders(){
        authenticationProvider = AuthenticationProvider()
    }

    private fun loginUser(){
        this.showLoader()
        // TODO-5 : utiliser authenticationProvider lancer la requete d'authentification

    }

    private fun showLoader(){
        loadingDialog.show()
    }

    private fun hideLoader(){
        loadingDialog.hide()
    }

    override fun onFailure(call: Call<User>, t: Throwable) {
        hideLoader()
        // TODO-6: Afficher un toast avec un message d'erreur
    }

    override fun onResponse(call: Call<User>, response: Response<User>) {
        hideLoader()
        // TODO-6: Verifier si les informations sont correctes, afficher un Toast à l'utilisateur puis rediriger l'utilisateur vers la page Home (HomeActivity)
    }

    private fun goToHomePage(){
        this.startActivity(HomeActivity.getIntent(this))
    }
}