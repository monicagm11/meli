package com.mcode.mercadolibre.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mcode.mercadolibre.PlpViewModel
import com.mcode.mercadolibre.R
import com.mcode.mercadolibre.databinding.FragmentPlpBinding
import com.mcode.mercadolibre.usecases.UseCasePlp

class PlpFragment: Fragment() {

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

        viewModel.getPlpListBySearchKeyWord("Lavadora")

        return binding!!.root
    }


}