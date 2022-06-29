package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Conditions (

	@SerializedName("context_restrictions") val contextRestrictions : List<String>? = emptyList(),
	@SerializedName("start_time") val startTime : String? = null,
	@SerializedName("end_time") val endTime : String? = null,
	@SerializedName("eligible") val eligible : Boolean? = null
)