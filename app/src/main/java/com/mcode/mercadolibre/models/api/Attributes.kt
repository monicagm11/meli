package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Attributes (

	@SerializedName("value_id") val valueId : Int,
	@SerializedName("value_name") val valueName : String,
	@SerializedName("values") val values : List<ValueAttributes>,
	@SerializedName("attribute_group_name") val attributeGroupName : String,
	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("value_struct") val valueStruct : Struct,
	@SerializedName("attribute_group_id") val attributeGroupId : String,
	@SerializedName("source") val source : Long
)

data class ValueAttributes(
	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("value_struct") val valueStruct : Struct,
	@SerializedName("source") val source : Long
)

data class Struct(
	@SerializedName("number") val number : Float,
	@SerializedName("unit") val unit : String
)