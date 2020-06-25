package com.bewizyu.mvvmarchitecture.app.home.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bewizyu.mvvmarchitecture.R
import com.bewizyu.mvvmarchitecture.app.home.view.adapter.FeedsListAdapter
import com.bewizyu.mvvmarchitecture.app.home.viewmodel.HomeViewModel
import com.bewizyu.mvvmarchitecture.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var feedsList: RecyclerView
    private val feedsListAdapter: FeedsListAdapter = FeedsListAdapter(arrayListOf())

    private lateinit var loading: ProgressBar
    private lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = homeViewModel

        feedsList = findViewById(R.id.feeds_list)
        loading = findViewById(R.id.progress)
        message = findViewById(R.id.message)

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
        homeViewModel.feedItems.observe(this, Observer {
            it?.let {
                feedsListAdapter.updateList(it)
            }
        })
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}