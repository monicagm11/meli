package com.mcode.mercadolibre.repositories.api

import com.mcode.mercadolibre.BuildConfig
import com.mcode.mercadolibre.models.api.ProductResponse
import com.mcode.mercadolibre.models.api.SearchResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiRepository {

    private val apiInterface: ApiInterface = ApiRetrofit().getRetrofit().create(ApiInterface::class.java)

    fun searchProductsByKeyWord(searchKeyWord: String, onSuccess: (SearchResponse)->Unit, onFailure: () -> Unit){
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val call = apiInterface.getProductList(BuildConfig.SITE_ID, searchKeyWord).execute()

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

    fun getProductDetail(productId: String, onSuccess: (ProductResponse)-> Unit, onFailure: () -> Unit){
        CoroutineScope(Dispatchers.IO).launch {
            try {

                var call = apiInterface.getProductDetail(productId).execute()

                if(call.isSuccessful){
                    var body = call.body()
                    onSuccess(body[0])
                }else{
                    onFailure()
                }

            }catch (e: Exception){
                e.message
                onFailure()
            }
        }
    }

}