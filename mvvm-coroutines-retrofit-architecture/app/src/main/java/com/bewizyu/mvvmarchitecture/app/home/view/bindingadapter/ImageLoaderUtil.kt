package com.bewizyu.mvvmarchitecture.app.home.view.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bewizyu.mvvmarchitecture.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(url: String) {
    val glideOptions = RequestOptions()
        .placeholder(CircularProgressDrawable(context).apply {
            strokeWidth = 10f
            centerRadius = 50f
            start()
        })
        .error(R.drawable.feed_placeholder)

    Glide.with(context)
        .setDefaultRequestOptions(glideOptions)
        .load(url)
        .into(this)
}

@BindingAdapter("android:imageUrl")
fun loadImageAdapter(view: ImageView, url: String?) {
    url?.let {
        view.loadImage(it)
    }
}