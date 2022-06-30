package com.mcode.mercadolibre.repositories.api

import com.google.gson.JsonSyntaxException
import com.mcode.mercadolibre.BuildConfig
import com.mcode.mercadolibre.models.api.ProductResponse
import com.mcode.mercadolibre.models.api.SearchResponse
import com.mcode.mercadolibre.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiRepository {

    private val apiInterface: ApiInterface = ApiRetrofit().getRetrofit().create(ApiInterface::class.java)

    fun searchProductsByKeyWord(searchKeyWord: String, onSuccess: (SearchResponse)->Unit, onFailure: (String) -> Unit){
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val call = apiInterface.getProductList(BuildConfig.SITE_ID, searchKeyWord).execute()

                if(call.isSuccessful){
                    var body = call.body()
                    onSuccess(body)
                }else{
                    onFailure(Constants.ERROR_API_CONNECTION)
                }

            }catch (e: JsonSyntaxException){
                onFailure(Constants.ERROR_API_SERIALIZATION)
            }catch (e: Exception){
                onFailure(Constants.ERROR_API_GENERAL)
            }
        }
    }

    fun getProductDetail(productId: String, onSuccess: (ProductResponse)-> Unit, onFailure: (String) -> Unit){
        CoroutineScope(Dispatchers.IO).launch {
            try {

                var call = apiInterface.getProductDetail(productId).execute()

                if(call.isSuccessful){
                    var body = call.body()
                    if(body.isNotEmpty()){
                        onSuccess(body[0])
                    }else{
                        onFailure(Constants.ERROR_API_EMPTY)
                    }

                }else{
                    onFailure(Constants.ERROR_API_CONNECTION)
                }

            }catch (e: JsonSyntaxException){
                onFailure(Constants.ERROR_API_SERIALIZATION)
            }catch (e: Exception){
                onFailure(Constants.ERROR_API_GENERAL)
            }
        }
    }

}