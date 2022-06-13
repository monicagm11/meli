import com.google.gson.annotations.SerializedName

data class ProductResult (

	@SerializedName("code") val code : Int,
	@SerializedName("body") val body : Body
)