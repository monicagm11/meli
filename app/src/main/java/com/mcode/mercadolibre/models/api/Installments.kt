package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Installments (

	@SerializedName("quantity") val quantity : Int,
	@SerializedName("amount") val amount : Double,
	@SerializedName("rate") val rate : Int? = null,
	@SerializedName("currency_id") val currencyId : String? = null
)