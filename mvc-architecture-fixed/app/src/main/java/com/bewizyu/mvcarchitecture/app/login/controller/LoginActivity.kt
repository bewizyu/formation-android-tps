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

    private fun initProviders(){
        authenticationProvider = AuthenticationProvider()
    }

    private fun loginUser(){
        this.showLoader()
        authenticationProvider.authenticate(LoginRequest(editTextEmail.text.toString(), editTextPassword.text.toString()))
            .enqueue(this)
    }

    private fun showLoader(){
        loadingDialog.show()
    }

    private fun hideLoader(){
        loadingDialog.hide()
    }

    override fun onFailure(call: Call<User>, t: Throwable) {
        hideLoader()
        Toast.makeText(this, resources.getString(R.string.unexpected_error), Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<User>, response: Response<User>) {
        hideLoader()
        val user = response.body()
        if(user != null){
            Toast.makeText(this, "Welcome ${user.fullName}", Toast.LENGTH_LONG).show()
            goToHomePage()
        }
    }

    private fun goToHomePage(){
        this.startActivity(HomeActivity.getIntent(this))
    }
}