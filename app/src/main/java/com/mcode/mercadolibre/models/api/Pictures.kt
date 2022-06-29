package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Pictures (

	@SerializedName("id") val id : String? = null,
	@SerializedName("url") val url : String,
	@SerializedName("secure_url") val secureUrl : String? = null,
	@SerializedName("size") val size : String? = null,
	@SerializedName("max_size") val maxSize : String? = null,
	@SerializedName("quality") val quality : String? = null
)