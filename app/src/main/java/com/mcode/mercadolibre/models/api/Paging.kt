package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Paging (

	@SerializedName("total") val total : Int? = null,
	@SerializedName("primary_results") val primaryResults : Int? = null,
	@SerializedName("offset") val offset : Int? = null,
	@SerializedName("limit") val limit : Int? = null
)