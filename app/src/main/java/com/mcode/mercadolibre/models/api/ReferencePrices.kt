import com.google.gson.annotations.SerializedName

data class ReferencePrices (

	@SerializedName("id") val id : Int,
	@SerializedName("type") val type : String,
	@SerializedName("conditions") val conditions : Conditions,
	@SerializedName("amount") val amount : Int,
	@SerializedName("currency_id") val currencyId : String,
	@SerializedName("exchange_rate_context") val exchangeRateContext : String,
	@SerializedName("tags") val tags : List<String>,
	@SerializedName("last_updated") val lastUpdated : String
)