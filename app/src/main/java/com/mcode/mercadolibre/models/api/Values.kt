package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Values (

	@SerializedName("id") val id : String? = null,
	@SerializedName("name") val name : String? = null,
	@SerializedName("results") val results : Int? = null
)