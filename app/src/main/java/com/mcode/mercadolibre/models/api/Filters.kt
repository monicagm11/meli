package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Filters (

	@SerializedName("id") val id : String? = null,
	@SerializedName("name") val name : String? = null,
	@SerializedName("type") val type : String? = null,
	@SerializedName("values") val values : List<Values>? = emptyList()
)