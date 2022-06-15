package com.mcode.mercadolibre.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.mcode.mercadolibre.R
import com.mcode.mercadolibre.databinding.FragmentMainBinding
import com.mcode.mercadolibre.viewmodels.MainFragmentViewModel

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    var viewModel : MainFragmentViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        initObservers()
        return binding.root
    }

    private fun initObservers(){
        viewModel?.goSearchNavigation?.observe(viewLifecycleOwner) { it ->
            it?.let {
                if (it) {
                    navigateToSearchFragment()
                }
                viewModel?.clearGoSearchNevigation()
            }
        }
    }

    private fun navigateToSearchFragment(){
        findNavController().navigate(MainFragmentDirections.navigationMainFragmentToSearchFragment())
    }


}