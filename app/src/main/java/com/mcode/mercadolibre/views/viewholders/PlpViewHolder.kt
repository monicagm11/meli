package com.mcode.mercadolibre.views.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mcode.mercadolibre.R
import com.mcode.mercadolibre.databinding.ViewholderPlpBinding
import com.mcode.mercadolibre.models.plp.PlpItem

class PlpViewHolder(var binding: ViewholderPlpBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindData(plpItem: PlpItem){
        binding.plpItem = plpItem

        binding.executePendingBindings()
    }

}