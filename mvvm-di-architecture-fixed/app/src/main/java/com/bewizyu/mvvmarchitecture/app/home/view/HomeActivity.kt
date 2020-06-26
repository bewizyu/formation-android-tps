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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bewizyu.mvvmarchitecture.R
import com.bewizyu.mvvmarchitecture.app.common.BaseActivity
import com.bewizyu.mvvmarchitecture.app.home.view.adapter.FeedsListAdapter
import com.bewizyu.mvvmarchitecture.app.home.viewmodel.HomeViewModel
import com.bewizyu.mvvmarchitecture.app.login.viewmodel.LoginViewModel
import com.bewizyu.mvvmarchitecture.databinding.ActivityHomeBinding
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val homeViewModel: HomeViewModel by viewModels(){
        viewModelFactory
    }

    private lateinit var feedsList: RecyclerView
    private val feedsListAdapter: FeedsListAdapter = FeedsListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = homeViewModel

        feedsList = findViewById(R.id.feeds_list)

        feedsList.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = feedsListAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        listenToViewModels()
        homeViewModel.load()
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