package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Values (

	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("results") val results : Int
)