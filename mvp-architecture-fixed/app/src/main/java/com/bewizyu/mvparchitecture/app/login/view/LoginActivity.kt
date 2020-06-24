package com.bewizyu.mvparchitecture.app.login.view

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bewizyu.mvparchitecture.R
import com.bewizyu.mvparchitecture.app.home.view.HomeActivity
import com.bewizyu.mvparchitecture.app.login.presenter.LoginPresenter
import com.bewizyu.mvparchitecture.core.login.net.AuthenticationProvider

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var buttonSignIn: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var loadingDialog: ProgressDialog


    private lateinit var loginPresenter: LoginPresenter

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
        loginPresenter = LoginPresenter(this, AuthenticationProvider())
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


    override fun hideLoader() {
        loadingDialog.hide()

    }

    override fun showLoader() {
        loadingDialog.show()

    }

    override fun redirectToHome() {
        this.startActivity(HomeActivity.getIntent(this))
    }

    override fun showLoginError() {
        Toast.makeText(this, resources.getString(R.string.unexpected_error), Toast.LENGTH_LONG)
            .show()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    }

    private fun loginUser() {
        loginPresenter.authenticate(
            email = editTextEmail.text.toString(),
            password = editTextPassword.text.toString()
        )
    }


}