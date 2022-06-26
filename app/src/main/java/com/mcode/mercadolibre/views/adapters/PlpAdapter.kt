package com.mcode.mercadolibre.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcode.mercadolibre.databinding.ViewholderPlpBinding
import com.mcode.mercadolibre.models.plp.PlpItem
import com.mcode.mercadolibre.views.viewholders.PlpViewHolder

class PlpAdapter(var plpItemList: List<PlpItem>): RecyclerView.Adapter<PlpViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlpViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ViewholderPlpBinding.inflate(inflater, parent, false)
        return PlpViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlpViewHolder, position: Int) {
        holder.bindData(plpItemList[position], context)
    }

    override fun getItemCount(): Int {
        return plpItemList.size
    }
}