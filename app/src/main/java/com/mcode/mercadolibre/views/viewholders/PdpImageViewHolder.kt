package com.mcode.mercadolibre.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.mcode.mercadolibre.databinding.ViewholderImagePdpBinding

class PdpImageViewHolder(var binding: ViewholderImagePdpBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindData(urlImage: String){
        binding.urlImage = urlImage
        binding.executePendingBindings()
    }

}