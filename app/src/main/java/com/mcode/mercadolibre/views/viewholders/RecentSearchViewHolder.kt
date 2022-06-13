package com.mcode.mercadolibre.views.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.mcode.mercadolibre.databinding.ViewholderRecentSearchBinding

class RecentSearchViewHolder(var binding: ViewholderRecentSearchBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindData(searchWord: String){
        binding.searchWord = searchWord
        binding.executePendingBindings()
    }

}