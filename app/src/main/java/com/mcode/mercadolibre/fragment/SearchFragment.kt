package com.mcode.mercadolibre.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mcode.mercadolibre.R
import com.mcode.mercadolibre.databinding.FragmentSearchBinding
import com.mcode.mercadolibre.viewmodels.SearchFragmentViewModel

class SearchFragment: Fragment() {
    lateinit var binding: FragmentSearchBinding
    var viewModel: SearchFragmentViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        viewModel = ViewModelProvider(this).get(SearchFragmentViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner =this

        viewModel?.getRecentSearchList()

        configurateSearchEditText()

        return binding.root
    }

    private fun configurateSearchEditText(){
        binding.edtSearchKeyword.setOnEditorActionListener { _, _, _ ->
            if (!viewModel!!.searchKeyWord.value.isNullOrBlank()) {
                viewModel!!.setSearchKeyWordSelected(viewModel!!.searchKeyWord.value!!)
                navigateToPlp()
                false
            } else {
                true
            }
        }
    }

    fun navigateToPlp(){

    }
}