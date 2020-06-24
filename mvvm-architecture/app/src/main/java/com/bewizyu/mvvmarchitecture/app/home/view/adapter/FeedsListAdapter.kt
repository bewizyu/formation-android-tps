package com.bewizyu.mvvmarchitecture.app.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bewizyu.mvvmarchitecture.R
import com.bewizyu.mvvmarchitecture.core.home.model.FeedItem
import kotlinx.android.synthetic.main.item_home_feed.view.*

class FeedsListAdapter(private val feedsItems : ArrayList<FeedItem>) : RecyclerView.Adapter<FeedsListAdapter.FeedViewHolder>(){

    class FeedViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun getItemCount() = feedsItems.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        //TODO-4 : afficher les informations du feed au bon endroit (title, description, likes et date)
    }

    fun updateList(items : ArrayList<FeedItem>){
        //TODO-5 : refrechir la liste : supprimer les elements de la liste puis ajouter les elements passés en parametre
        // Faire appel a notifyDataSetChanged() pour rafraichir les données sur la vue

    }

}