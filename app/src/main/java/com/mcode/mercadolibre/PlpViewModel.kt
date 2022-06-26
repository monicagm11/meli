package com.mcode.mercadolibre

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mcode.mercadolibre.models.plp.PlpItem
import com.mcode.mercadolibre.usecases.UseCasePlp
import com.mcode.mercadolibre.views.adapters.PlpAdapter

class PlpViewModel(app: Application): AndroidViewModel(app) {
    
    var useCasePlp: UseCasePlp = UseCasePlp()

    var plpAdapter: MutableLiveData<PlpAdapter> = MutableLiveData<PlpAdapter>()
    
    fun getPlpListBySearchKeyWord(searchKeyWord: String){
        useCasePlp.getSearchProductList(searchKeyWord = searchKeyWord, 
            onSuccess = { list: List<PlpItem> ->  
            val adapter = PlpAdapter(list)
                plpAdapter.postValue(adapter)
                adapter.notifyDataSetChanged()
        }, onFailure = {

        })
    }
    
}