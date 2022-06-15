package com.mcode.mercadolibre.usecases

import com.mcode.mercadolibre.models.api.Installments
import com.mcode.mercadolibre.models.api.PriceItem
import com.mcode.mercadolibre.models.api.Results
import com.mcode.mercadolibre.models.plp.PlpItem
import com.mcode.mercadolibre.models.plp.PricePlp
import com.mcode.mercadolibre.repositories.api.ApiRepository
import com.mcode.mercadolibre.utils.Constants
import java.text.NumberFormat
import java.util.*
import kotlin.math.roundToInt

class UseCasePlp {

    val numberFormat: NumberFormat = NumberFormat.getInstance(Locale.GERMANY)

    fun getSearchProductList(searchKeyWord: String, onSuccess: (List<PlpItem>)->Unit, onFailure: () -> Unit){
        ApiRepository().searchProductsByKeyWord(
            searchKeyWord = searchKeyWord,
            onSuccess = {searchResponse ->
                var results = searchResponse.results
                var plpItemList: List<PlpItem> = results.map { result -> getPlpItem(result) }
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
        return PlpItem(id = results.id,
            title = results.title,
            price = pricePlp,
            imgUrl = results.thumbnail,
            installments = getInstallmentText(results.installments),
            freeSend = isFree,
            fullSend = isFull
        )
    }

    private fun getInstallmentText(installments: Installments): String{
        return "en ${installments.quantity} x ${numberFormat.format(installments.amount.roundToInt())}"
    }

    private fun getPrice(prices:List<PriceItem>): PriceItem{
        var priceSelected = prices.find { price -> price.type == Constants.PRICE_PROMOTIONAL }
        return priceSelected ?: prices[0]
    }

    private fun getPricePlp(priceItem: PriceItem): PricePlp {
        var discountValue = 0
        if(priceItem.type == Constants.PRICE_PROMOTIONAL && priceItem.regularAmount > 0){
            discountValue = ((priceItem.regularAmount - priceItem.amount) * 100 / priceItem.regularAmount).toDouble()
                .roundToInt()
        }

        return PricePlp(price = "$ ${numberFormat.format(priceItem.amount)}",
            currencyId = priceItem.currencyId,
            discount = (if (discountValue > 0)  "${discountValue}% OFF" else null))
    }

}