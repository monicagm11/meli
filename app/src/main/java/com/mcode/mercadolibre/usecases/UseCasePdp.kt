package com.mcode.mercadolibre.usecases

import com.mcode.mercadolibre.models.AttributePdp
import com.mcode.mercadolibre.models.PdpDetail
import com.mcode.mercadolibre.models.api.*
import com.mcode.mercadolibre.models.plp.PricePlp
import com.mcode.mercadolibre.repositories.api.ApiRepository
import com.mcode.mercadolibre.utils.Constants

class UseCasePdp : BaseUseCase(){

    fun getDetailProductList(productId: String, onSuccess: (PdpDetail)->Unit, onFailure: (String) -> Unit){
        ApiRepository().getProductDetail(
            productId = productId,
            onSuccess = {productResponse ->
                val result = productResponse.body
                result?.let {
                    val pdpItem = getPdpItem(it)
                    onSuccess(pdpItem)
                }?: run{
                    onFailure(Constants.ERROR_API_EMPTY)
                }

            },
            onFailure = {
                onFailure(it)
            })
    }

    private fun getPdpItem(body: Body): PdpDetail{
        val pricePlp = getPricePdp(body.originalPrice, body.price, body.currencyId)
        val tags = body.shipping?.tags
        var isFree = false
        var isFull = false

        tags?.let {
            isFree = it.contains(Constants.SHIPPING_FREE)
            isFull = it.contains(Constants.SHIPPING_FULL)
        }


        return PdpDetail( id = body.id,
            title = body.title,
            price = pricePlp,
            imgUrl = getPicturesUrl(body.pictures.orEmpty()),
            freeSend = isFree,
            fullSend = isFull,
            attributePdp = getAttributesList(body.attributes.orEmpty()),
            location = getLocationText(body.sellerAddress))
    }

    fun getPicturesUrl(pictureList: List<Pictures>): List<String>{
        return pictureList.map { it.url }
    }

    fun getAttributesList(attributesList: List<Attributes>): List<AttributePdp>{
        return attributesList.filter{ attributes->
            return@filter !attributes.name.isNullOrBlank() && !attributes.valueName.isNullOrBlank()
        }.map { attribute -> AttributePdp( id = attribute.id,
            name = attribute.name.orEmpty(),
            valueName = attribute.valueName.orEmpty()) }
    }

    fun getLocationText(sellerAddress: SellerAddress): String{
        return "${sellerAddress.city.name}, ${sellerAddress.state.name}"
    }

    private fun getPricePdp(originalPrice: Float, price: Float, currencyId: String):PricePlp{
        return PricePlp(price = "$ ${numberFormat.format(price)}",
            currencyId = currencyId,
            discount = getDiscountText(originalPrice, price))
    }
}