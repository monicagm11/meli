package com.mcode.mercadolibre.models

import com.mcode.mercadolibre.models.plp.PricePlp

data class PdpDetail(
    val id : String,
    val title : String,
    val price: PricePlp,
    val imgUrl : List<String>,
    val freeSend : Boolean = false,
    val fullSend : Boolean = false,
    val attributePdp: List<AttributePdp> = arrayListOf(),
    val location: String? = null
)

data class AttributePdp(
    val id: String,
    val name: String,
    val valueName : String
)
