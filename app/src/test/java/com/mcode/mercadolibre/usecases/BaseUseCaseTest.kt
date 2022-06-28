package com.mcode.mercadolibre.usecases

import com.mcode.mercadolibre.models.api.Installments
import org.junit.Assert
import org.junit.Test

class BaseUseCaseTest {

    val baseUseCase: BaseUseCase = BaseUseCase()

    @Test
    fun `getInstallmentTextCorrectly`(){
        val expected = "en 36 x $ 50.000"
        val installment = Installments(
            quantity = 36,
            49999.8,
            1,
            "COP"
        )

        Assert.assertEquals(expected, baseUseCase.getInstallmentText(installment))
    }

    @Test
    fun `getInstallmentTextInCorrectly`(){
        val expected = "en 36 x $ 50.000"
        val installment = Installments(
            quantity = 12,
            49999.8,
            1,
            "COP"
        )

        Assert.assertNotEquals(expected, baseUseCase.getInstallmentText(installment))
    }

    @Test
    fun `getDiscountTextCorrectly`(){
        val expected = "20% OFF"
        Assert.assertEquals(expected, baseUseCase.getDiscountText(1000000F, 800000F))
    }

    @Test
    fun `getDiscountTextNullCorrectly`(){
        Assert.assertNull(baseUseCase.getDiscountText(0F, 800000F))
    }
}