package com.mcode.mercadolibre.viewmodels

import android.app.Application
import android.content.Context
import android.net.Network
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mcode.mercadolibre.models.plp.PlpItem
import com.mcode.mercadolibre.usecases.UseCasePlp
import com.mcode.mercadolibre.utils.Constants
import com.mcode.mercadolibre.utils.NetWorkUtils
import com.mcode.mercadolibre.views.adapters.PlpAdapter

class PlpViewModel(application: Application): AndroidViewModel(application) {

    val context: Context = application
    var isFirstTime: Boolean = true
    
    var useCasePlp: UseCasePlp = UseCasePlp()

    var plpAdapter: MutableLiveData<PlpAdapter?> = MutableLiveData<PlpAdapter?>()

    var showLoading = MutableLiveData<Boolean>()
    var showRecyclerView = MutableLiveData<Boolean>()
    var showEmptyState = MutableLiveData<Boolean>()
    var errorEmptyState = MutableLiveData<String>()

    var searchKeyWord = MutableLiveData<String>()

    var navigateToSearch = MutableLiveData<Boolean?>()
    var itemPdpSelected = MutableLiveData<String?>()
    
    fun getPlpListBySearchKeyWord(){
        showLoading()
        if(NetWorkUtils.isOnline(context)){
            useCasePlp.getSearchProductList(searchKeyWord = searchKeyWord.value!!,
                onSuccess = { list: List<PlpItem> ->
                    val adapter = PlpAdapter(list)
                    plpAdapter.postValue(adapter)
                    adapter.notifyDataSetChanged()
                    showRecyclerView()

                }, onFailure = {
                    errorEmptyState.postValue(it)
                    showEmptyState()
                })
        }else{
            errorEmptyState.postValue(Constants.ERROR_API_INTERNET)
            showEmptyState()
        }

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