package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class SearchResponse (

	@SerializedName("site_id") val siteId : String? = null,
	@SerializedName("country_default_time_zone") val countryDefaultTimeZone : String? = null,
	@SerializedName("query") val query : String? = null,
	@SerializedName("paging") val paging : Paging? = null,
	@SerializedName("results") val results : List<Results>? = emptyList(),
	@SerializedName("sort") val sort : Sort? = null,
	@SerializedName("available_sorts") val availableSorts : List<Sort>? = emptyList(),
	@SerializedName("filters") val filters : List<Filters>? = emptyList(),
	@SerializedName("available_filters") val availableFilters : List<Filters>? = emptyList()
)