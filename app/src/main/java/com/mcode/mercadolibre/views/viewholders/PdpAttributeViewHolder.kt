package com.mcode.mercadolibre.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.mcode.mercadolibre.databinding.ViewholderAttributePdpBinding
import com.mcode.mercadolibre.models.AttributePdp

class PdpAttributeViewHolder(var binding: ViewholderAttributePdpBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindData(attribute: AttributePdp){
        binding.attribute = attribute
        binding.executePendingBindings()
    }

}