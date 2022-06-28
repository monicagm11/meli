package com.mcode.mercadolibre.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mcode.mercadolibre.models.plp.PlpItem
import com.mcode.mercadolibre.usecases.UseCasePlp
import com.mcode.mercadolibre.views.adapters.PlpAdapter

class PlpViewModel: ViewModel() {

    var isFirstTime: Boolean = true
    
    var useCasePlp: UseCasePlp = UseCasePlp()

    var plpAdapter: MutableLiveData<PlpAdapter?> = MutableLiveData<PlpAdapter?>()

    var showLoading = MutableLiveData<Boolean>()
    var showRecyclerView = MutableLiveData<Boolean>()
    var showEmptyState = MutableLiveData<Boolean>()

    var searchKeyWord = MutableLiveData<String>()

    var navigateToSearch = MutableLiveData<Boolean?>()
    var itemPdpSelected = MutableLiveData<String?>()
    
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

    fun initViewModel(){

        plpAdapter.observeForever {
            it?.let {
                it.idItemSelected?.observeForever {
                    it?.let {
                        itemPdpSelected.value = it
                        plpAdapter.value!!.idItemSelected.value = null
                    }
                }
            }
        }

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

    fun clearItemPlpSelected(){
        itemPdpSelected.value = null
    }
}