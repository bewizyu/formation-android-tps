package com.bewizyu.mvvmarchitecture.app.home.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bewizyu.mvvmarchitecture.R
import com.bewizyu.mvvmarchitecture.app.home.view.adapter.FeedsListAdapter
import com.bewizyu.mvvmarchitecture.app.home.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    //TODO-9 : Observer : initalisation du viewModel via le delegate viewModels()

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var feedsList: RecyclerView
    private val feedsListAdapter: FeedsListAdapter = FeedsListAdapter(arrayListOf())

    private lateinit var loading: ProgressBar
    private lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        feedsList = findViewById(R.id.feeds_list)
        loading = findViewById(R.id.progress)
        message = findViewById(R.id.message)

        //TODO-6 : Observer : l'initialisation du RecyclerView avec le bon Adapter
        feedsList.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = feedsListAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        homeViewModel.load()
        listenToViewModels()
    }

    private fun listenToViewModels(){
        //TODO-10 : maintenant vous pouvez ecoutez les evenements en provenance des differents LiveData dans homeViewModel
        // Hint :
        //homeViewModel.feedItems.observe(this, Observer {
        //            // ici update des données
        //        })
        // Ecouter les evenements emis par homeViewModel.feedItems pour mettre  à jours la liste
        // Ecouter les evenements emis par homeViewModel.loading pour mettre  à jours la visibilité du ProgressBar
        // Ecouter les evenements emis par showMessage.loading pour mettre  à jours la visibilité du message d'erreur (R.id.message)


    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}