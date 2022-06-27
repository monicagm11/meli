package com.mcode.mercadolibre.usecases

import com.mcode.mercadolibre.models.api.PriceItem
import com.mcode.mercadolibre.models.api.Results
import com.mcode.mercadolibre.models.plp.PlpItem
import com.mcode.mercadolibre.models.plp.PricePlp
import com.mcode.mercadolibre.repositories.api.ApiRepository
import com.mcode.mercadolibre.utils.Constants

class UseCasePlp: BaseUseCase() {

    fun getSearchProductList(searchKeyWord: String, onSuccess: (List<PlpItem>)->Unit, onFailure: () -> Unit){
        ApiRepository().searchProductsByKeyWord(
            searchKeyWord = searchKeyWord,
            onSuccess = {searchResponse ->
                val results = searchResponse.results
                val plpItemList: List<PlpItem> = results.map { result -> getPlpItem(result) }
                onSuccess(plpItemList)
            },
            onFailure = {
                onFailure()
            })
    }

    private fun getPlpItem (results: Results): PlpItem {
        val price = getPrice(results.prices.prices)
        val pricePlp = getPricePlp(price)
        val tags = results.shipping.tags
        val isFree = tags.contains(Constants.SHIPPING_FREE)
        val isFull = tags.contains(Constants.SHIPPING_FULL)
        var installmentText: String? = null
        results.installments?.let {
            installmentText = getInstallmentText(it)
        }
        return PlpItem(id = results.id,
            title = results.title,
            price = pricePlp,
            imgUrl = results.thumbnail,
            installments = installmentText,
            freeSend = isFree,
            fullSend = isFull
        )
    }

    fun getPrice(prices:List<PriceItem>): PriceItem {
        var priceSelected = prices.find { price -> price.type == Constants.PRICE_PROMOTIONAL }
        return priceSelected ?: prices[0]
    }

    fun getPricePlp(priceItem: PriceItem): PricePlp {
        var discountValue: String? = null
        if(priceItem.type == Constants.PRICE_PROMOTIONAL && priceItem.regularAmount > 0){
            discountValue = getDiscountText(priceItem.regularAmount, priceItem.amount)
        }

        return PricePlp(price = "$ ${numberFormat.format(priceItem.amount)}",
            currencyId = priceItem.currencyId,
            discount = discountValue)
    }



}