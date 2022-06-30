package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Results (

	@SerializedName("id") val id : String,
	@SerializedName("site_id") val siteId : String? = null,
	@SerializedName("title") val title : String,
	@SerializedName("seller") val seller : Seller? = null,
	@SerializedName("price") val price : Int? = null,
	@SerializedName("prices") val prices : Prices,
	@SerializedName("sale_price") val salePrice : String? = null,
	@SerializedName("currency_id") val currencyId : String? = null,
	@SerializedName("available_quantity") val availableQuantity : Int? = null,
	@SerializedName("sold_quantity") val soldQuantity : Int? = null,
	@SerializedName("buying_mode") val buyingMode : String? = null,
	@SerializedName("listing_type_id") val listingTypeId : String? = null,
	@SerializedName("stop_time") val stopTime : String? = null,
	@SerializedName("condition") val condition : String? = null,
	@SerializedName("permalink") val permalink : String? = null,
	@SerializedName("thumbnail") val thumbnail : String,
	@SerializedName("thumbnail_id") val thumbnailId : String? = null,
	@SerializedName("accepts_mercadopago") val acceptsMercadopago : Boolean? = null,
	@SerializedName("installments") val installments : Installments? = null,
	@SerializedName("address") val address : Address? = null,
	@SerializedName("shipping") val shipping : Shipping? = null,
	@SerializedName("seller_address") val sellerAddress : SellerAddress? = null,
	@SerializedName("attributes") val attributes : List<Attributes>? = emptyList(),
	@SerializedName("original_price") val originalPrice : String? = null,
	@SerializedName("category_id") val categoryId : String? = null,
	@SerializedName("official_store_id") val officialStoreId : String? = null,
	@SerializedName("domain_id") val domainId : String? = null,
	@SerializedName("catalog_product_id") val catalogProductId : String? = null,
	@SerializedName("tags") val tags : List<String>? = emptyList(),
	@SerializedName("catalog_listing") val catalogListing : Boolean? = null,
	@SerializedName("use_thumbnail_id") val useThumbnailId : Boolean? = null,
	@SerializedName("offer_score") val offerScore : String? = null,
	@SerializedName("offer_share") val offerShare : String? = null,
	@SerializedName("match_score") val matchScore : String? = null,
	@SerializedName("winner_item_id") val winnerItemId : String? = null,
	@SerializedName("melicoin") val melicoin : String? = null,
	@SerializedName("discounts") val discounts : String? = null,
	@SerializedName("order_backend") val orderBackend : Int? = null
)