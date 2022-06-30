package com.mcode.mercadolibre.utils

class Constants {

    companion object{
        const val PRICE_PROMOTIONAL = "promotion"
        const val PRICE_STANDARD = "standard"

        const val SHIPPING_FREE = "mandatory_free_shipping"
        const val SHIPPING_FULL = "fulfillment"
        const val SHIPPING_SELF_SERVICE = "self_service_in"

        const val ERROR_API_GENERAL = "Ha ocurrido un error, por favor inténtelo más tarde"
        const val ERROR_API_EMPTY = "No se han encontrado resultados para su consulta, por favor intente con una nueva búsqueda"
        const val ERROR_API_CONNECTION = "No se ha podido realizar su consulta en este momento, por favor inténtelo más tarde"
        const val ERROR_API_SERIALIZATION = "Ha ocurrido un error procesando la consulta, por favor inténtelo más tarde"
        const val ERROR_API_INTERNET = "Verifique su conexión a internet para poder realizar esta consulta"
    }

}