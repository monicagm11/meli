package com.mcode.mercadolibre.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mcode.mercadolibre.models.PdpDetail
import com.mcode.mercadolibre.usecases.UseCasePdp
import com.mcode.mercadolibre.utils.Constants
import com.mcode.mercadolibre.utils.NetWorkUtils
import com.mcode.mercadolibre.views.adapters.AttributePdpAdapter
import com.mcode.mercadolibre.views.adapters.ImagesPdpAdapter

class PdpViewModel(app: Application): AndroidViewModel(app) {

    val context: Context = app
    var isFirstTime = true

    var useCasePdp = UseCasePdp()

    var productId: String = ""
    var pdpDetail = MutableLiveData<PdpDetail>()

    var pdpImageAdapter: MutableLiveData<ImagesPdpAdapter> = MutableLiveData<ImagesPdpAdapter>()
    var pdpAttributeAdapter: MutableLiveData<AttributePdpAdapter> = MutableLiveData<AttributePdpAdapter>()

    var showLoading = MutableLiveData<Boolean>()
    var showPdpContent = MutableLiveData<Boolean>()
    var showEmptyState = MutableLiveData<Boolean>()
    var errorEmptyState = MutableLiveData<String>()

    var navigateToSearch = MutableLiveData<Boolean?>()


    fun getPdpDetailById(){
        showLoading()
        if(NetWorkUtils.isOnline(context)){
        useCasePdp.getDetailProductList(productId,
            onSuccess = {detail ->
                pdpDetail.postValue(detail)
            },
            onFailure = {
                errorEmptyState.postValue(it)
                showEmptyState()
            })
        }else{
            errorEmptyState.postValue(Constants.ERROR_API_INTERNET)
            showEmptyState()
        }
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