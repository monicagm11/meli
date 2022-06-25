package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Pictures (

	@SerializedName("id") val id : String,
	@SerializedName("url") val url : String,
	@SerializedName("secure_url") val secureUrl : String,
	@SerializedName("size") val size : String,
	@SerializedName("max_size") val maxSize : String,
	@SerializedName("quality") val quality : String
)