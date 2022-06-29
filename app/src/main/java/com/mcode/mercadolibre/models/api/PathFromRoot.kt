package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class PathFromRoot (

	@SerializedName("id") val id : String? = null,
	@SerializedName("name") val name : String? = null
)