package com.mcode.mercadolibre.models.api

import com.google.gson.annotations.SerializedName

data class Body (

	@SerializedName("id") val id : String,
	@SerializedName("site_id") val siteId : String,
	@SerializedName("title") val title : String,
	@SerializedName("subtitle") val subtitle : String,
	@SerializedName("seller_id") val sellerId : Int,
	@SerializedName("category_id") val categoryId : String,
	@SerializedName("official_store_id") val officialStoreId : String,
	@SerializedName("price") val price : Int,
	@SerializedName("base_price") val basePrice : Int,
	@SerializedName("original_price") val originalPrice : String,
	@SerializedName("currency_id") val currencyId : String,
	@SerializedName("initial_quantity") val initialQuantity : Int,
	@SerializedName("available_quantity") val availableQuantity : Int,
	@SerializedName("sold_quantity") val soldQuantity : Int,
	@SerializedName("sale_terms") val saleTerms : List<SaleTerms>,
	@SerializedName("buying_mode") val buyingMode : String,
	@SerializedName("listing_type_id") val listingTypeId : String,
	@SerializedName("start_time") val startTime : String,
	@SerializedName("stop_time") val stopTime : String,
	@SerializedName("condition") val condition : String,
	@SerializedName("permalink") val permalink : String,
	@SerializedName("thumbnail_id") val thumbnailId : String,
	@SerializedName("thumbnail") val thumbnail : String,
	@SerializedName("secure_thumbnail") val secureThumbnail : String,
	@SerializedName("pictures") val pictures : List<Pictures>,
	@SerializedName("video_id") val videoId : String,
	@SerializedName("descriptions") val descriptions : List<String>,
	@SerializedName("accepts_mercadopago") val acceptsMercadopago : Boolean,
	@SerializedName("non_mercado_pago_payment_methods") val nonMercadoPagoPaymentMethods : List<String>,
	@SerializedName("shipping") val shipping : Shipping,
	@SerializedName("international_delivery_mode") val internationalDeliveryMode : String,
	@SerializedName("seller_address") val sellerAddress : SellerAddress,
	@SerializedName("seller_contact") val sellerContact : String,
	@SerializedName("coverage_areas") val coverageAreas : List<String>,
	@SerializedName("attributes") val attributes : List<Attributes>,
	@SerializedName("warnings") val warnings : List<String>,
	@SerializedName("listing_source") val listingSource : String,
	@SerializedName("variations") val variations : List<String>,
	@SerializedName("status") val status : String,
	@SerializedName("sub_status") val subStatus : List<String>,
	@SerializedName("tags") val tags : List<String>,
	@SerializedName("warranty") val warranty : String,
	@SerializedName("catalog_product_id") val catalogProductId : String,
	@SerializedName("domain_id") val domainId : String,
	@SerializedName("parent_item_id") val parentItemId : String,
	@SerializedName("differential_pricing") val differentialPricing : String,
	@SerializedName("deal_ids") val dealIds : List<String>,
	@SerializedName("automatic_relist") val automaticRelist : Boolean,
	@SerializedName("date_created") val dateCreated : String,
	@SerializedName("last_updated") val lastUpdated : String,
	@SerializedName("health") val health : String,
	@SerializedName("catalog_listing") val catalogListing : Boolean,
	@SerializedName("channels") val channels : List<String>
)