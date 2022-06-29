package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Attributes (

	@SerializedName("value_id") val valueId : Int,
	@SerializedName("value_name") val valueName : String? = null,
	@SerializedName("values") val values : List<ValueAttributes>? = emptyList(),
	@SerializedName("attribute_group_name") val attributeGroupName : String? = null,
	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String? = null,
	@SerializedName("value_struct") val valueStruct : Struct? = null,
	@SerializedName("attribute_group_id") val attributeGroupId : String? = null,
	@SerializedName("source") val source : Long? = null
)

data class ValueAttributes(
	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String? = null,
	@SerializedName("value_struct") val valueStruct : Struct? = null,
	@SerializedName("source") val source : Long? = null
)

data class Struct(
	@SerializedName("number") val number : Float? = null,
	@SerializedName("unit") val unit : String? = null
)