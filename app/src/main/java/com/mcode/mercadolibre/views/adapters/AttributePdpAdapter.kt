package com.mcode.mercadolibre.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mcode.mercadolibre.R
import com.mcode.mercadolibre.databinding.ViewholderAttributePdpBinding
import com.mcode.mercadolibre.models.AttributePdp
import com.mcode.mercadolibre.views.viewholders.PdpAttributeViewHolder

class AttributePdpAdapter(val list: List<AttributePdp>): RecyclerView.Adapter<PdpAttributeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdpAttributeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewholderAttributePdpBinding>(inflater, R.layout.viewholder_attribute_pdp, parent, false)
        return PdpAttributeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PdpAttributeViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}