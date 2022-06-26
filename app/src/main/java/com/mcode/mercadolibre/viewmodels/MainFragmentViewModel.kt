package com.mcode.mercadolibre.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainFragmentViewModel(app: Application): AndroidViewModel(app) {

    val goSearchNavigation = MutableLiveData<Boolean?>()


    fun startGoSearchNavigation(){
        goSearchNavigation.value = true
    }

    fun clearGoSearchNevigation(){
        goSearchNavigation.value = null
    }

}