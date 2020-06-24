package com.bewizyu.mvparchitecture.app.login.view

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.bewizyu.mvparchitecture.R
import com.bewizyu.mvparchitecture.app.login.presenter.LoginPresenter
import com.bewizyu.mvparchitecture.core.login.net.AuthenticationProvider

// TODO-2 implementer l'interface LoginView et override les methodes
class LoginActivity : AppCompatActivity() {

    private lateinit var buttonSignIn: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var loadingDialog: ProgressDialog


    //TODO-4 : declarer un attribut de type LoginPresenter poour l'initialiser dans initPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_login)
        initViewComponents()
        initPresenter()
    }

    private fun initPresenter() {

     }

    private fun initViewComponents() {
        buttonSignIn = findViewById(R.id.sign_in_btn)
        editTextEmail = findViewById(R.id.user_email_address)
        editTextPassword = findViewById(R.id.user_password)
        buttonSignIn.setOnClickListener {
            loginUser()
        }
        loadingDialog = ProgressDialog.show(
            this@LoginActivity, "",
            resources.getString(R.string.loading), true
        )
        loadingDialog.hide()
    }




    private fun loginUser() {
        //TODO-5 : faire appel a authenticate pour declancher le traitement d'authentification coté presenter
    }


}