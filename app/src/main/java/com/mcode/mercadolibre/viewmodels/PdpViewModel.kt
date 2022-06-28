package com.mcode.mercadolibre.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mcode.mercadolibre.models.PdpDetail
import com.mcode.mercadolibre.usecases.UseCasePdp
import com.mcode.mercadolibre.views.adapters.AttributePdpAdapter
import com.mcode.mercadolibre.views.adapters.ImagesPdpAdapter

class PdpViewModel(): ViewModel() {

    var isFirstTime = true

    var useCasePdp = UseCasePdp()

    var productId: String = ""
    var pdpDetail = MutableLiveData<PdpDetail>()

    var pdpImageAdapter: MutableLiveData<ImagesPdpAdapter> = MutableLiveData<ImagesPdpAdapter>()
    var pdpAttributeAdapter: MutableLiveData<AttributePdpAdapter> = MutableLiveData<AttributePdpAdapter>()

    var showLoading = MutableLiveData<Boolean>()
    var showPdpContent = MutableLiveData<Boolean>()
    var showEmptyState = MutableLiveData<Boolean>()

    var navigateToSearch = MutableLiveData<Boolean?>()


    fun getPdpDetailById(){
        showLoading()
        useCasePdp.getDetailProductList(productId,
            onSuccess = {detail ->
                pdpDetail.postValue(detail)
            },
            onFailure = {
                showEmptyState()
            })
    }

    fun initObservers(){
        pdpDetail.observeForever {
            it?.let {
                initPdpImageAdapter()
                initPdpAttributeAdapter()
                showPdpContent()
            }
        }
    }

    fun initPdpImageAdapter(){
        val adapter = ImagesPdpAdapter(pdpDetail.value!!.imgUrl)
        pdpImageAdapter.postValue(adapter)
        adapter.notifyDataSetChanged()
    }

    fun initPdpAttributeAdapter(){
        val adapter = AttributePdpAdapter(pdpDetail.value!!.attributePdp)
        pdpAttributeAdapter.postValue(adapter)
        adapter.notifyDataSetChanged()
    }

    fun showLoading(){
        showLoading.postValue(true)
        showPdpContent.postValue(false)
        showEmptyState.postValue(false)
    }

    fun showPdpContent(){
        showLoading.postValue(false)
        showPdpContent.postValue(true)
        showEmptyState.postValue(false)
    }

    fun showEmptyState(){
        showLoading.postValue(false)
        showPdpContent.postValue(false)
        showEmptyState.postValue(true)
    }

    fun initNavigateToSearch(){
        navigateToSearch.value = true
    }

    fun clearNavigateToSearch(){
        navigateToSearch.value = null
    }


}