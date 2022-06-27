package com.mcode.mercadolibre.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.mcode.mercadolibre.databinding.ViewholderRecentSearchBinding
import com.mcode.mercadolibre.views.viewholders.RecentSearchViewHolder

class RecentSearchAdapter(var recentSearchList: ArrayList<String>): RecyclerView.Adapter<RecentSearchViewHolder>() {

    var searchItemSelected = MutableLiveData<String?>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentSearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewholderRecentSearchBinding.inflate(inflater, parent, false)
        return RecentSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentSearchViewHolder, position: Int) {
        holder.bindData(recentSearchList[position])
        holder.itemView.setOnClickListener{
            searchItemSelected.value = recentSearchList[position]
        }
    }

    override fun getItemCount(): Int {
        return recentSearchList.size
    }
}