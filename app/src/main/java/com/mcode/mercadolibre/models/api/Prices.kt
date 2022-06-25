package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Prices (

	@SerializedName("id") val id : String,
	@SerializedName("prices") val prices : List<PriceItem>,
	@SerializedName("presentation") val presentation : Presentation,
	@SerializedName("payment_method_prices") val paymentMethodPrices : List<String>,
	@SerializedName("reference_prices") val referencePrices : List<ReferencePrices>,
	@SerializedName("purchase_discounts") val purchaseDiscounts : List<String>
)

data class PriceItem(
	@SerializedName("id") val id : String,
	@SerializedName("type") val type : String,
	@SerializedName("amount") val amount : Int,
	@SerializedName("regular_amount") val regularAmount : Int,
	@SerializedName("currency_id") val currencyId : String
)