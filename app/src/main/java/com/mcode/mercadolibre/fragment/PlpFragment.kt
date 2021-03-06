package com.mcode.mercadolibre.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mcode.mercadolibre.viewmodels.PlpViewModel
import com.mcode.mercadolibre.R
import com.mcode.mercadolibre.databinding.FragmentPlpBinding

class PlpFragment: BaseFragment() {

    var binding: FragmentPlpBinding? = null
    lateinit var viewModel: PlpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_plp, container, false)
        viewModel = ViewModelProvider(this).get(PlpViewModel::class.java)
        binding!!.viewmodel = viewModel
        binding!!.lifecycleOwner = this

        val args: PlpFragmentArgs by navArgs()

        args?.let {
            viewModel.searchKeyWord.value = args.searchKeyWord
        }

        if(viewModel.isFirstTime){
            viewModel.initViewModel()
            viewModel.getPlpListBySearchKeyWord()
            viewModel.isFirstTime = false
        }

        initObservables()

        binding!!.imgBack.setOnClickListener {
            onBack()
        }

        return binding!!.root
    }

    fun initObservables(){
        viewModel.navigateToSearch.observe(viewLifecycleOwner) {
            it?.let {
                navigateToSearch()
                viewModel.clearNavigateToSearch()
            }
        }

        viewModel.itemPdpSelected.observe(viewLifecycleOwner){
            it?.let {
                navigateToPdp(it)
                viewModel.clearItemPlpSelected()
            }
        }
    }

    fun navigateToSearch(){
        findNavController().navigate(PlpFragmentDirections.navigationPlpFragmentToSearchFragment())
    }

    fun navigateToPdp(productId: String){
        findNavController().navigate(PlpFragmentDirections.navigationPlpFragmentToPdpFragment(productId))
    }




}