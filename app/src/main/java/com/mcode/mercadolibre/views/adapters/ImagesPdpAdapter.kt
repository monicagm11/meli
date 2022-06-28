package com.mcode.mercadolibre.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mcode.mercadolibre.R
import com.mcode.mercadolibre.databinding.ViewholderImagePdpBinding
import com.mcode.mercadolibre.views.viewholders.PdpImageViewHolder

class ImagesPdpAdapter(var list: List<String>): RecyclerView.Adapter<PdpImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdpImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewholderImagePdpBinding>(inflater, R.layout.viewholder_image_pdp, parent, false)
        return PdpImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PdpImageViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}