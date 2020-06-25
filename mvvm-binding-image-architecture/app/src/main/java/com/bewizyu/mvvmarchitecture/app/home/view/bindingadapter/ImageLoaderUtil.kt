package com.bewizyu.mvvmarchitecture.app.home.view.bindingadapter

import android.widget.ImageView


//TODO-1 : créer une extension de la classe Image view qui permet de charger une image via url en utilisant Glide
// dans RequestOptions de glide definir un placeholder de type CircularProgressDrawable dont les attributs sont strokeWidth = 10f et centerRadius = 50f
// utiliser le drawable feed_placeholder comme placeholder en cas d'erreur
// charger l'url


fun ImageView.loadImage(url: String) {

}


//TODO-2 : utiliser @BindingAdapter pour declarer la fonction loadImageAdapter comme un binding adapter associé a l'attribut android:imageUrl
// et utiliser l'extension load image pour charger l'image
fun loadImageAdapter(view: ImageView, url: String?) {

}