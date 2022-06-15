package com.mcode.mercadolibre.repositories.api

import com.mcode.mercadolibre.models.api.ProductResponse
import com.mcode.mercadolibre.models.api.SearchResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiRepository {

    private val apiInterface: ApiInterface = ApiRetrofit().getRetrofit().create(ApiInterface::class.java)
    private val siteId = "MCO"

    fun searchProductsByKeyWord(searchKeyWord: String, onSuccess: (SearchResponse)->Unit, onFailure: () -> Unit){
        CoroutineScope(Dispatchers.IO).launch {
            try {

                var call = apiInterface.getProductList(siteId, searchKeyWord).execute()

                if(call.isSuccessful){
                    var body = call.body()
                    onSuccess(body)
                }else{
                    onFailure()
                }

            }catch (e: Exception){
                e.toString()
                onFailure()
            }
        }
    }


}