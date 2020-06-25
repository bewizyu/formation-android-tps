package com.bewizyu.mvvmarchitecture.app.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bewizyu.mvvmarchitecture.R
import com.bewizyu.mvvmarchitecture.app.home.view.bindingadapter.loadImage
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import com.bewizyu.mvvmarchitecture.databinding.ItemHomeFeedBinding
import kotlinx.android.synthetic.main.item_home_feed.view.*
import timber.log.Timber

class FeedsListAdapter(private val feedsItems: ArrayList<FeedItem>) :
    RecyclerView.Adapter<FeedsListAdapter.FeedViewHolder>() {

    class FeedViewHolder(val bindingView: ItemHomeFeedBinding) :
        RecyclerView.ViewHolder(bindingView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = DataBindingUtil.inflate<ItemHomeFeedBinding>(
            inflater,
            R.layout.item_home_feed,
            parent,
            false
        )
        return FeedViewHolder(view)
    }

    override fun getItemCount() = feedsItems.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bindingView.feedItem = feedsItems[position]
        Timber.d("LOAD IMAGE ${feedsItems[position].image}")
    }

    fun updateList(items: ArrayList<FeedItem>) {
        feedsItems.clear()
        feedsItems.addAll(items)
        notifyDataSetChanged()
    }

}