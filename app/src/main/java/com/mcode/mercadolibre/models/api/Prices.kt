package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Prices (

	@SerializedName("id") val id : String? = null,
	@SerializedName("prices") val prices : List<PriceItem>,
	@SerializedName("presentation") val presentation : Presentation? = null,
	@SerializedName("payment_method_prices") val paymentMethodPrices : List<String>? = emptyList(),
	@SerializedName("reference_prices") val referencePrices : List<ReferencePrices>? = emptyList(),
	@SerializedName("purchase_discounts") val purchaseDiscounts : List<String>? = emptyList()
)

data class PriceItem(
	@SerializedName("id") val id : String? = null,
	@SerializedName("type") val type : String? = null,
	@SerializedName("amount") val amount : Float,
	@SerializedName("regular_amount") val regularAmount : Float,
	@SerializedName("currency_id") val currencyId : String
)