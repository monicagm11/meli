package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Presentation (

	@SerializedName("display_currency") val displayCurrency : String
)