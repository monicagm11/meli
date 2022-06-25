package com.mcode.mercadolibre.usecases

import com.mcode.mercadolibre.models.AttributePdp
import com.mcode.mercadolibre.models.PdpDetail
import com.mcode.mercadolibre.models.api.*
import com.mcode.mercadolibre.models.plp.PricePlp
import com.mcode.mercadolibre.repositories.api.ApiRepository
import com.mcode.mercadolibre.utils.Constants

class UseCasePdp : BaseUseCase(){

    fun getDetailProductList(productId: String, onSuccess: (PdpDetail)->Unit, onFailure: () -> Unit){
        ApiRepository().getProductDetail(
            productId = productId,
            onSuccess = {productResponse ->
                val result = productResponse.body
                val pdpItem = getPdpItem(result)
                onSuccess(pdpItem)
            },
            onFailure = {
                onFailure()
            })
    }

    private fun getPdpItem(body: Body): PdpDetail{
        val pricePlp = getPricePdp(body.originalPrice, body.price, body.currencyId)
        val tags = body.shipping.tags
        val isFree = tags.contains(Constants.SHIPPING_FREE)
        val isFull = tags.contains(Constants.SHIPPING_FULL)
        return PdpDetail( id = body.id,
            title = body.title,
            price = pricePlp,
            imgUrl = getPicturesUrl(body.pictures),
            freeSend = isFree,
            fullSend = isFull,
            attributePdp = getAttributesList(body.attributes),
            location = getLocationText(body.sellerAddress))
    }

    private fun getPicturesUrl(pictureList: List<Pictures>): List<String>{
        return pictureList.map { it.url }
    }

    private fun getAttributesList(attributesList: List<Attributes>): List<AttributePdp>{
        return attributesList.map { attribute -> AttributePdp( id = attribute.id,
            name = attribute.name,
            valueName = attribute.valueName) }
    }

    private fun getLocationText(sellerAddress: SellerAddress): String{
        return "${sellerAddress.city.name}, ${sellerAddress.state.name}"
    }

    private fun getPricePdp(originalPrice: Int, price: Int, currencyId: String):PricePlp{
        return PricePlp(price = "$ ${numberFormat.format(price)}",
            currencyId = currencyId,
            discount = getDiscountText(originalPrice, price))
    }
}