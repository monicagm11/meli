package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class ProductResponse (

	@SerializedName("code") val code : Int? = null,
	@SerializedName("body") val body : Body? = null
)