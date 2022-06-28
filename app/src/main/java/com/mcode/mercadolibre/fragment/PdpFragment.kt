package com.mcode.mercadolibre.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.mcode.mercadolibre.R
import com.mcode.mercadolibre.databinding.FragmentPdpBinding
import com.mcode.mercadolibre.viewmodels.PdpViewModel

class PdpFragment: BaseFragment() {

    var binding: FragmentPdpBinding? = null
    lateinit var viewModel: PdpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pdp, container, false)
        viewModel = ViewModelProvider(this).get(PdpViewModel::class.java)
        binding!!.viewmodel = viewModel
        binding!!.lifecycleOwner = this

        val args: PdpFragmentArgs by navArgs()

        args?.let {
            viewModel.productId = args.productId
        }

        if(viewModel.isFirstTime){
            viewModel.initObservers()
            viewModel.getPdpDetailById()
            viewModel.isFirstTime = false
        }

        return binding!!.root
    }


}