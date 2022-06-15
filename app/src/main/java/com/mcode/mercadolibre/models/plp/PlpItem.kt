package com.mcode.mercadolibre.models.plp

data class PlpItem (
        val id : String,
        val title : String,
        val price : PricePlp,
        val imgUrl : String,
        val installments : String?=null,
        val freeSend : Boolean = false,
        val fullSend : Boolean = false
        )

data class PricePlp(
        val price: String,
        val currencyId : String,
        val discount: String?
)