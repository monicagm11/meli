package com.mcode.mercadolibre.fragment

import androidx.fragment.app.Fragment
import com.mcode.mercadolibre.MainActivity

open class BaseFragment: Fragment() {

    fun onBack(){
        (activity as MainActivity).onBackPressed()
    }
}