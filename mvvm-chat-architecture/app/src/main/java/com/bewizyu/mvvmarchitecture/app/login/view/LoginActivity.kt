package com.bewizyu.mvvmarchitecture.app.login.view

import android.app.Activity
import android.content.Intent
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
import androidx.lifecycle.ViewModelProvider
import com.bewizyu.mvvmarchitecture.R
import com.bewizyu.mvvmarchitecture.app.chat.view.ChatActivity
import com.bewizyu.mvvmarchitecture.app.common.BaseActivity
import com.bewizyu.mvvmarchitecture.app.home.view.HomeActivity
import com.bewizyu.mvvmarchitecture.app.login.viewmodel.LoginViewModel
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity() {

    companion object {
        const val RC_SIGN_IN = 390
    }
    private lateinit var buttonSignIn: Button
    private lateinit var buttonGoogleSignIn: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var loading: ProgressBar

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val loginViewModel: LoginViewModel by viewModels(){
        viewModelFactory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_login)
        initViewComponents()
        listenToViewModels()

    }

    override fun onStart() {
        super.onStart()
        // TODO VERIFIER SI L UTILISATEUR EST EN LIGNE
    }


    private fun initViewComponents() {

        buttonSignIn = findViewById(R.id.sign_in_btn)
        editTextEmail = findViewById(R.id.user_email_address)
        editTextPassword = findViewById(R.id.user_password)
        loading = findViewById(R.id.login_loading)
        buttonGoogleSignIn = google_sign_in_btn

        buttonSignIn.setOnClickListener {
            loginUser()
        }
        buttonGoogleSignIn.setOnClickListener {
            showGoogleSignInDialog()
        }

    }

    private fun showGoogleSignInDialog(){
        this.startActivity(ChatActivity.getIntent(this))

        // TODO : https://firebase.google.com/docs/auth/android/firebaseui#kotlin+ktx
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // TODO apres verification de l'utilisateur Ouvrir l'activité ChatActivity
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in


            } else {
                Toast.makeText(this, getString(R.string.unexpected_error), Toast.LENGTH_SHORT).show()


            }
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