import com.google.gson.annotations.SerializedName

data class SaleTerms (

	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("value_id") val valueId : String,
	@SerializedName("value_name") val valueName : String,
	@SerializedName("value_struct") val valueStruct : Struct,
	@SerializedName("values") val values : List<ValueAttributes>
)