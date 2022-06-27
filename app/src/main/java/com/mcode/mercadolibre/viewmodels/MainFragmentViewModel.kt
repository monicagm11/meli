package com.mcode.mercadolibre.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel: ViewModel() {

    val goSearchNavigation = MutableLiveData<Boolean?>()


    fun startGoSearchNavigation(){
        goSearchNavigation.value = true
    }

    fun clearGoSearchNevigation(){
        goSearchNavigation.value = null
    }

}