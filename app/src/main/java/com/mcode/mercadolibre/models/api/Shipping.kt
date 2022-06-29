package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Shipping (

	@SerializedName("free_shipping") val freeShipping : Boolean? = null,
	@SerializedName("mode") val mode : String? = null,
	@SerializedName("tags") val tags : List<String>? = null,
	@SerializedName("logistic_type") val logisticType : String? = null,
	@SerializedName("store_pick_up") val storePickUp : Boolean? = null
)