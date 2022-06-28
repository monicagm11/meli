package com.mcode.mercadolibre.usecases

import com.mcode.mercadolibre.models.api.Installments

import java.text.NumberFormat
import java.util.*
import kotlin.math.roundToInt

open class BaseUseCase {

    val numberFormat: NumberFormat = NumberFormat.getInstance(Locale.GERMANY)

    fun getInstallmentText(installments: Installments): String{
        return "en ${installments.quantity} x $ ${numberFormat.format(installments.amount.roundToInt())}"
    }

    fun getDiscountText(regularAmount : Float, amount: Float ): String?{
        var discountValue = 0
        if(regularAmount > 0){
            discountValue = ((regularAmount - amount) * 100 / regularAmount).toDouble()
                .roundToInt()
        }
        return if (discountValue > 0)  "${discountValue}% OFF" else null
    }

}