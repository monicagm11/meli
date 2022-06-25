package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Paging (

	@SerializedName("total") val total : Int,
	@SerializedName("primary_results") val primaryResults : Int,
	@SerializedName("offset") val offset : Int,
	@SerializedName("limit") val limit : Int
)