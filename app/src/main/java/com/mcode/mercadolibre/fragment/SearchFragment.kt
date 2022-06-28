package com.mcode.mercadolibre.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mcode.mercadolibre.MainActivity
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

        configureSearchEditText()
        configureBackButton()
        initObservables()

        return binding.root
    }

    private fun configureSearchEditText(){
        binding.edtSearchKeyword.setOnEditorActionListener { _, _, _ ->
            if (!viewModel!!.searchKeyWord.value.isNullOrBlank()) {
                viewModel!!.setSearchKeyWordSelected(viewModel!!.searchKeyWord.value!!)

                return@setOnEditorActionListener false
            }
            return@setOnEditorActionListener true
        }

    }

    private fun configureBackButton(){
        binding.imgBack.setOnClickListener {
            onBack()
        }
    }

    private fun initObservables(){
        viewModel!!.navigateToPlp.observe(viewLifecycleOwner) {
            it?.let {
                navigateToPlp()
                viewModel!!.clearNavigateToPlp()
            }
        }
    }

    private fun navigateToPlp(){
        findNavController().navigate(SearchFragmentDirections.navigationSearchFragmentToPlpFragment(viewModel!!.searchKeyWordSelected.value!!))
    }

    fun onBack(){
        (activity as MainActivity).onBackPressed()
    }
}