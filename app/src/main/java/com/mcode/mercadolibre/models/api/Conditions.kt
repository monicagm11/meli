package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Conditions (

	@SerializedName("context_restrictions") val contextRestrictions : List<String>,
	@SerializedName("start_time") val startTime : String,
	@SerializedName("end_time") val endTime : String,
	@SerializedName("eligible") val eligible : Boolean
)