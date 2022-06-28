package com.mcode.mercadolibre.repositories.api


import com.mcode.mercadolibre.models.api.ProductResponse
import com.mcode.mercadolibre.models.api.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("sites/{siteId}/search")
    fun getProductList(@Path("siteId") siteId: String, @Query("q") searchKeyWord: String): Call<SearchResponse>

    @GET("items")
    fun getProductDetail(@Query("ids") productId: String): Call<List<ProductResponse>>

}