package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Seller (

	@SerializedName("id") val id : Int? = null,
	@SerializedName("permalink") val permalink : String? = null,
	@SerializedName("registration_date") val registrationDate : String? = null,
	@SerializedName("car_dealer") val carDealer : Boolean? = null,
	@SerializedName("real_estate_agency") val realEstateAgency : Boolean? = null
)