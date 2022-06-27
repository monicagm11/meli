package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Seller (

	@SerializedName("id") val id : Int,
	@SerializedName("permalink") val permalink : String,
	@SerializedName("registration_date") val registrationDate : String,
	@SerializedName("car_dealer") val carDealer : Boolean,
	@SerializedName("real_estate_agency") val realEstateAgency : Boolean
)