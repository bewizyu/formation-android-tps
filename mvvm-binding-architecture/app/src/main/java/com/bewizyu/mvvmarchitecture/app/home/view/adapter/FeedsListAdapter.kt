package com.bewizyu.mvvmarchitecture.app.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bewizyu.mvvmarchitecture.R
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import kotlinx.android.synthetic.main.item_home_feed.view.*

class FeedsListAdapter(private val feedsItems : ArrayList<FeedItem>) : RecyclerView.Adapter<FeedsListAdapter.FeedViewHolder>(){

    // TODO-5 : modifier le ViewHolder pour avoir en parametre ItemHomeFeedBinding
    class FeedViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        // TODO-4 : utiliser le DataBindingUtil pour construire la vue ( PS : ItemHomeFeedBinding)
        // DataBindingUtil.inflate<>(
        //            inflater,
        //            R.layout.item_home_feed,
        //            parent,
        //            false
        //        )
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun getItemCount() = feedsItems.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        // TODO-6 : assigner le feedItem associé à au ItemHomeFeedBinding porté par le viewHolder ( holder.bindingView.feedItem )

        holder.view.user_name.text = feedsItems[position].title
        holder.view.caption_text.text = feedsItems[position].description
        holder.view.date_added.text = feedsItems[position].date
        holder.view.like_number.text = feedsItems[position].likes.toString()
    }

    fun updateList(items : ArrayList<FeedItem>){
        feedsItems.clear()
        feedsItems.addAll(items)
        notifyDataSetChanged()
    }

}