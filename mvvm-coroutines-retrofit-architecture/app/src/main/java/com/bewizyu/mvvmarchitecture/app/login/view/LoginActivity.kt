package com.bewizyu.mvvmarchitecture.app.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bewizyu.mvvmarchitecture.R
import com.bewizyu.mvvmarchitecture.app.home.view.HomeActivity
import com.bewizyu.mvvmarchitecture.app.login.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var buttonSignIn: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var loading: ProgressBar
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_login)
        initViewComponents()
        listenToViewModels()

    }


    private fun initViewComponents() {

        buttonSignIn = findViewById(R.id.sign_in_btn)
        editTextEmail = findViewById(R.id.user_email_address)
        editTextPassword = findViewById(R.id.user_password)
        loading = findViewById(R.id.login_loading)

        buttonSignIn.setOnClickListener {
            loginUser()
        }

    }

    private fun listenToViewModels(){
        loginViewModel.userData.observe(this, Observer {
            it?.let {
                Toast.makeText(this@LoginActivity, "Bienvenue ${it.fullName}", Toast.LENGTH_LONG).show()
                redirectToHome()
            }
        })

        loginViewModel.loading.observe(this, Observer {
            it?.let {
                loading.visibility = if(it) View.VISIBLE else View.GONE
            }
        })
        loginViewModel.errorMessage.observe(this, Observer {
            it?.let {
                Toast.makeText(this@LoginActivity, it, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun redirectToHome() {
        this.startActivity(HomeActivity.getIntent(this))
    }


    private fun loginUser() {
        loginViewModel.authenticate(
            userEmail = editTextEmail.text.toString(),
            userPassword = editTextPassword.text.toString()
        )
    }


}