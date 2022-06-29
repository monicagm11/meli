package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class SaleTerms (

	@SerializedName("id") val id : String? = null,
	@SerializedName("name") val name : String? = null,
	@SerializedName("value_id") val valueId : String? = null,
	@SerializedName("value_name") val valueName : String? = null,
	@SerializedName("value_struct") val valueStruct : Struct? = null,
	@SerializedName("values") val values : List<ValueAttributes>? = emptyList()
)