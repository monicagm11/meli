package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class ReferencePrices (

	@SerializedName("id") val id : Int? = null,
	@SerializedName("type") val type : String? = null,
	@SerializedName("conditions") val conditions : Conditions? = null,
	@SerializedName("amount") val amount : Float? = null,
	@SerializedName("currency_id") val currencyId : String? = null,
	@SerializedName("exchange_rate_context") val exchangeRateContext : String? = null,
	@SerializedName("tags") val tags : List<String>? = emptyList(),
	@SerializedName("last_updated") val lastUpdated : String? = null
)