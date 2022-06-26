package com.mcode.mercadolibre.views

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mcode.mercadolibre.R

@BindingAdapter(value = ["loadImageFromUrl"], requireAll = false)
fun loadImageFromUrl(appCompatImageView: AppCompatImageView, url: String?){
    if(url!=null && url.isNotBlank()){
        Glide.with(appCompatImageView.context)
            .load(url)
            .placeholder(R.drawable.ic_no_image)
            .fitCenter()
            .into(appCompatImageView)
    }
}