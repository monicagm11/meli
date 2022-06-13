import com.google.gson.annotations.SerializedName

data class SearchResult (

	@SerializedName("site_id") val siteId : String,
	@SerializedName("country_default_time_zone") val countryDefaultTimeZone : String,
	@SerializedName("query") val query : String,
	@SerializedName("paging") val paging : Paging,
	@SerializedName("results") val results : List<Results>,
	@SerializedName("sort") val sort : Sort,
	@SerializedName("available_sorts") val availableSorts : List<Sort>,
	@SerializedName("filters") val filters : List<Filters>,
	@SerializedName("available_filters") val availableFilters : List<Filters>
)