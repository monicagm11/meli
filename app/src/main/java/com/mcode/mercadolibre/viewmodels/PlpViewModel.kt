package com.mcode.mercadolibre.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mcode.mercadolibre.models.plp.PlpItem
import com.mcode.mercadolibre.usecases.UseCasePlp
import com.mcode.mercadolibre.views.adapters.PlpAdapter

class PlpViewModel(app: Application): AndroidViewModel(app) {
    
    var useCasePlp: UseCasePlp = UseCasePlp()

    var plpAdapter: MutableLiveData<PlpAdapter> = MutableLiveData<PlpAdapter>()

    var showLoading = MutableLiveData<Boolean>()
    var showRecyclerView = MutableLiveData<Boolean>()
    var showEmptyState = MutableLiveData<Boolean>()

    var searchKeyWord = MutableLiveData<String>()

    var navigateToSearch = MutableLiveData<Boolean?>()
    
    fun getPlpListBySearchKeyWord(){
        showLoading()
        useCasePlp.getSearchProductList(searchKeyWord = searchKeyWord.value!!,
            onSuccess = { list: List<PlpItem> ->
            if(list.isNotEmpty()){
                val adapter = PlpAdapter(list)
                plpAdapter.postValue(adapter)
                adapter.notifyDataSetChanged()
                showRecyclerView()
            }else{
                showEmptyState()
            }

        }, onFailure = {
            showEmptyState()
        })
    }

    fun showLoading(){
        showLoading.postValue(true)
        showRecyclerView.postValue(false)
        showEmptyState.postValue(false)
    }

    fun showRecyclerView(){
        showLoading.postValue(false)
        showRecyclerView.postValue(true)
        showEmptyState.postValue(false)
    }

    fun showEmptyState(){
        showLoading.postValue(false)
        showRecyclerView.postValue(false)
        showEmptyState.postValue(true)
    }

    fun initNavigateToSearch(){
        navigateToSearch.value = true
    }

    fun clearNavigateToSearch(){
        navigateToSearch.value = null
    }
}